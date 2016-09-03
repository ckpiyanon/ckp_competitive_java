import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n,m,u,v;
		while(in.ready()) {
			n = Integer.parseInt(in.readLine());
			while(graph.size() < n)	graph.add(new ArrayList<Integer>());
			for(ArrayList<Integer> l:graph)	l.clear();
			for(int i = 0;i < n;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine()," ()");
				u = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				while(m-- > 0) {
					v = Integer.parseInt(st.nextToken());
					graph.get(u).add(v);	graph.get(v).add(u);
				}
			}
			bridges.clear();
			low = new int[n]; num = new int[n]; parent = new int[n];
			Arrays.fill(num,-1);
			rank = 0;
			for(int i = 0;i < n;i++)	parent[i] = i;
			for(int i = 0;i < n;i++)	if(num[i] == -1)	dfs(i);
			Collections.sort(bridges);
			System.out.println(bridges.size() + " critical links");
			for(Pair p:bridges)	System.out.println(p);
			System.out.println();
			in.readLine();
		}
	}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Pair> bridges = new ArrayList<Pair>();
	
	static int low[],num[],parent[],rank;
	static void dfs(int u) {
		low[u] = num[u] = rank++;
		for(Integer v:graph.get(u)) {
			if(num[v] == -1) {
				parent[v] = u;
				dfs(v);
				low[u] = Math.min(low[u],low[v]);
				if(low[v] > num[u])	bridges.add(new Pair(u,v));
			}
			else if(parent[u] != v)	low[u] = Math.min(low[u],num[v]);
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int a,b;
		public Pair(int a,int b) {this.a = Math.min(a,b); this.b = Math.max(a,b);}
		public String toString() {return a + " - " + b;}
		public int compareTo(Pair p) {
			if(a == p.a)	return b - p.b;
			return a - p.a;
		}
	}
}
