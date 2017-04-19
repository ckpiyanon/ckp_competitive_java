import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Point> list = new ArrayList<Point>(500);
		ArrayList<Edge> edges = new ArrayList<Edge>(125250);
		DecimalFormat df = new DecimalFormat("0.00");
		UnionFind uf;
		int TC = getInt(),s,p;
		double d;
		while(TC-- > 0) {
			s = getInt(); p = getInt(); list.clear(); edges.clear();
			while(p-- > 0)	list.add(new Point(getInt(),getInt()));
			for(int i = 0;i < list.size();i++) for(int j = i + 1;j < list.size();j++)
				edges.add(new Edge(i,j,list.get(i).distance(list.get(j))));
			Collections.sort(edges); uf = new UnionFind(list.size()); d = 0.0;
			for(Edge e:edges) if(uf.find(e.u) != uf.find(e.v)) {
				uf.merge(e.u,e.v);
				d = e.w;
			}
			out.write(df.format(d) + "\n");
		}
		out.flush();
	}
	static class Edge implements Comparable<Edge> {
		int u,v;
		double w;
		Edge(int uu,int vv,double ww) {u = uu; v = vv; w = ww;}
		public int compareTo(Edge e) {return Double.compare(w,e.w);}
	}
	static class Point {
		double x,y;
		Point(double xx,double yy) {x = xx; y = yy;}
		double distance(Point p) {return Math.sqrt(Math.pow(x - p.x,2) + Math.pow(y - p.y,2));}
	}
	static class UnionFind {
		int[] parent,rank;
		int size;
		UnionFind(int sz) {
			parent = new int[sz];
			rank = new int[sz];
			size = sz;
			for(int i = 0;i < sz;i++) {parent[i] = i; rank[i] = 0;}
		}
		int find(int n) {return parent[n] = n == parent[n] ? n:find(parent[n]);}
		void merge(int a,int b) {
			a = find(a); b = find(b);
			if(a == b)	return;
			if(rank[a] == rank[b]) {
				parent[a] = b;
				rank[b]++;
			}
			else if(rank[a] > rank[b])	parent[b] = a;
			else	parent[a] = b;
			size--;
		}
	}
}
