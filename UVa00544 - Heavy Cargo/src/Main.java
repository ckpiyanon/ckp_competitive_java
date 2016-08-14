import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	static StreamTokenizer st;
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	
	static int numCity;
	static HashMap<String,Integer> map;
	static int getNum(String s) {
		Integer n = map.get(s);
		if(n != null)	return n;
		map.put(s,numCity);
		return numCity++;
	}
	static ArrayList<Edge> graph = new ArrayList<Edge>();
	
	static int kruskal(int src,int des) {
		UnionFind.reset();
		for(Edge e:graph) {
			if(UnionFind.same(e.u,e.v))	continue;
			UnionFind.union(e.u,e.v);
			if(UnionFind.same(src,des))	return -e.w;
		}
		return 0;
	}
	
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		map = new HashMap<String,Integer>();
		int n,TC = 0;
		while(getInt() != 0 & (n = getInt()) != 0) {
			map.clear();
			graph.clear();
			numCity = 0;
			while(n-- > 0)	graph.add(new Edge(getNum(getString()),getNum(getString()),-getInt()));
			Collections.sort(graph);
			System.out.println("Scenario #" + ++TC + "\n" + kruskal(getNum(getString()),getNum(getString())) + " tons\n");
		}
	}
	static class Edge implements Comparable<Edge> {
		public int u,v,w;
		public Edge(int u,int v,int w) {this.u = u; this.v = v; this.w = w;}
		public int compareTo(Edge e) {return w - e.w;}
	}
	static class UnionFind {
		static int[] parent = new int[200];
		public static boolean same(int a,int b) {return find(a) == find(b);}
		public static int find(int n) {
			int p = n,t;
			while(p != parent[p])	p = parent[p];
			while(n != parent[p]) {
				t = parent[n];
				parent[n] = p;
				n = t;
			}
			return p;
		}
		public static void union(int a,int b) {
			int ap = find(a),bp = find(b);
			if(ap != bp)	parent[ap] = bp;
		}
		public static void reset() {
			for(int i = 0;i < 200;i++)
				parent[i] = i;
		}
	}
}
