import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		int N,u,v;
		for(int i = 0;i < 100;i++)	graph.add(new ArrayList<Integer>());
		while((N = Integer.parseInt(in.readLine())) != 0) {
			for(int i = 0;i < N;i++)	graph.get(i).clear();
			while(!(s = in.readLine()).equals("0")) {
				st = new StringTokenizer(s);
				u = Integer.parseInt(st.nextToken()) - 1;
				while(st.hasMoreTokens()) {
					v = Integer.parseInt(st.nextToken()) - 1;
					graph.get(u).add(v);	graph.get(v).add(u);
				}
			}
			Arrays.fill(numChildren,0);
			rank = numCutVertices = 0;
			visited.clear();
			isCut.clear();
			for(int i = 0;i < N;i++)	parent[i] = i;
			for(int i = 0;i < N;i++)	if(!visited.get(i)) {
				root = i;
				dfs(i);
			}
			System.out.println(isCut.cardinality());
		}
	}
	static void dfs(int u) {
		visited.set(u);
		num[u] = low[u] = rank++;
		for(Integer v:graph.get(u)) {
			if(!visited.get(v)) {
				if(u == root)	numChildren[u]++;
				parent[v] = u;
				dfs(v);
				low[u] = Math.min(low[u],low[v]);
				if(u != root && low[v] >= num[u])	isCut.set(u);
			}
			else if(parent[u] != v)	low[u] = Math.min(low[u],num[v]);
		}
		if(numChildren[u] > 1 && u == root)	isCut.set(u);
	}
	static BitSet visited = new BitSet(100);
	static BitSet isCut = new BitSet(100);
	static int root,parent[] = new int[100],numChildren[] = new int[100];
	static int low[] = new int[100],num[] = new int[100],rank,numCutVertices;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(100);
}
