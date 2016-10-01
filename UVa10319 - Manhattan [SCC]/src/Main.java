import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Stack;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static final int MAXN = 120;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt();
		for(int i = 0;i < MAXN;i++)	graph.add(new ArrayList<Integer>());
		while(TC-- > 0) {
			int nS = getInt(),nA = getInt(),m = getInt(),n = (nS + nA) * 2;
			for(ArrayList<Integer> each:graph)	each.clear();
			while(m-- > 0) {
				int s1 = getInt() - 1,a1 = getInt() + nS - 1,s2 = getInt() - 1,a2 = getInt() + nS - 1;
				int distS = s1 - s2,distA = a1 - a2;
				if(distS == 0 && distA == 0)	continue;
				int dirS = distA > 0 ? 1:0;
				int dirA = distS > 0 ? 1:0;
				if(distS == 0)
					add(s1,dirS ^ 1,s1,dirS);
				else if(distA == 0)
					add(a1,dirA ^ 1,a1,dirA);
				else {
					add(s1,dirS^1,s2,dirS);	add(s1,dirS^1,a1,dirA);
					add(a2,dirA^1,s2,dirS);	add(a2,dirA^1,a1,dirA);
					add(s2,dirS^1,s1,dirS);	add(s2,dirS^1,a2,dirA);
					add(a1,dirA^1,s1,dirS);	add(a1,dirA^1,a2,dirA);
				}
			}
			uf = new UnionFind(n);
			stack.clear();
			visited.clear();
			Arrays.fill(num,-1);
			Arrays.fill(low,-1);
			scc = 1;
			for(int i = 0;i < n;i++)	if(num[i] == -1)	dfs(i);
			boolean yes = true;
			for(int i = 0;i < n && yes;i += 2)
				if(uf.isSameSet(i,i^1))
					yes = false;
			System.out.println(yes ? "Yes":"No");
		}
	}
	static int[] num = new int[MAXN],low = new int[MAXN];
	static Stack<Integer> stack = new Stack<Integer>();
	static BitSet visited = new BitSet(1000);
	static int scc;
	static void dfs(int u) {
		low[u] = num[u] = scc++;
		visited.set(u);
		stack.push(u);
		for(Integer v:graph.get(u)) {
			if(num[v] == -1)	dfs(v);
			if(visited.get(v))	low[u] = Math.min(low[u],low[v]);
		}
		if(low[u] == num[u]) {
			while(!stack.isEmpty()) {
				int v = stack.pop();
				uf.merge(u,v);
				visited.set(v,false);
				if(u == v)	break;
			}
		}
	}
	static void add(int from,int f,int to,int t) {graph.get(from*2 + f).add(to*2 + t);}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(MAXN);
	static UnionFind uf;
	static class UnionFind {
		private int[] parent,rank;
		private int size;
		public UnionFind(int size) {
			this.size = size;
			parent = new int[size];
			rank = new int[size];
			for(int i = 0;i < size;i++) {parent[i] = i;	rank[i] = 0;}
		}
		public int find(int a) {
			if(a == parent[a])	return a;
			return parent[a] = find(parent[a]);
		}
		public void merge(int a,int b) {
			a = find(a); b = find(b);
			if(a == b)	return;
			if(rank[a] == rank[b]) {
				parent[a] = b;
				rank[b]++;
			}
			else if(rank[a] > rank[b])
				parent[b] = a;
			else
				parent[a] = b;
		}
		public boolean isSameSet(int a,int b) {return find(a) == find(b);}
		public int size() {return size;}
	}
}
