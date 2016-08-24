import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static double getDouble() throws Exception {st.nextToken(); return st.nval;}
	static int getInt() throws Exception {return (int)getDouble();}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		ArrayList<Edge> graph = new ArrayList<Edge>();
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		int TC = getInt(),n;
		double total;
		boolean first = true;
		while(TC-- > 0) {
			n = getInt();	pairs.clear();	graph.clear();
			uf_init(n);
			while(n-- > 0)	pairs.add(new Pair(getDouble(),getDouble()));
			for(int i = 0;i < pairs.size();i++) for(int j = i + 1;j < pairs.size();j++)
				graph.add(new Edge(i,j,pairs.get(i).distance(pairs.get(j))));
			total = 0; Collections.sort(graph);
			for(Edge e:graph) {
				if(uf_find(e.u) == uf_find(e.v))	continue;
				total += e.w;
				uf_join(e.u,e.v);
				if(uf_size == 1)	break;
			}
			if(!first)	System.out.println();
			first = false;
			System.out.printf("%.2f\n",total);
		}
	}
	
	static class Pair {
		public double x,y;
		public Pair(double x,double y) {this.x = x; this.y = y;}
		public double distance(Pair p) {
			return Math.sqrt(Math.pow(x - p.x,2) + Math.pow(y - p.y,2));
		}
	}
	
	static class Edge implements Comparable<Edge> {
		public int u,v;
		public double w;
		public Edge(int u,int v,double w) {
			this.u = u; this.v = v; this.w = w;
		}
		public int compareTo(Edge e) {return Double.compare(w,e.w);}
	}
	static int uf_size;
	static int[] uf_parent = new int[100];
	static void uf_init(int n) {
		for(int i = 0;i < n;i++)	uf_parent[i] = i;
		uf_size = n;
	}
	static int uf_find(int n) {
		int t,x = n;
		while(x != uf_parent[x])	x = uf_parent[x];
		while(n != uf_parent[n]) {
			t = uf_parent[n];
			uf_parent[n] = x;
			n = t;
		}
		return x;
	}
	static void uf_join(int a,int b) {
		a = uf_find(a); b = uf_find(b);
		if(a != b)	uf_parent[a] = b;
	}
}
