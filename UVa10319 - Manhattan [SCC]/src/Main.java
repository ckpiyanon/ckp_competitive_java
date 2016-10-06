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
			stack.clear();
			visited.clear();
			Arrays.fill(num,-1);
			Arrays.fill(low,-1);
			scc = 1;
			for(int i = 0;i < n;i++)	if(num[i] == -1)	dfs(i);
			boolean yes = true;
			for(int i = 0;i < n && yes;i += 2)
				if(roots[i] == roots[i^1])
					yes = false;
			System.out.println(yes ? "Yes":"No");
		}
	}
	static int[] num = new int[MAXN],low = new int[MAXN],roots = new int[MAXN];
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
				roots[v] = u;
				visited.set(v,false);
				if(u == v)	break;
			}
		}
	}
	static void add(int from,int f,int to,int t) {graph.get(from*2 + f).add(to*2 + t);}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(MAXN);
}
