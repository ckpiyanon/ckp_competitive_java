import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	// UVa10147 - Highways
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StreamTokenizer(in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Point[] points = new Point[750];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int TC = getInt();
		while(TC-- > 0) {
			clear();
			int n = getInt();
			for(int i = 0;i < n;i++)	points[i] = new Point(getInt(),getInt());
			int m = getInt();
			while(m-- > 0)	merge(getInt() - 1,getInt() - 1);
			
			edges.clear();
			for(int i = 0;i < n;i++) for(int j = i+1;j < n;j++) {
				if(find(i) != find(j))
					edges.add(new Edge(i,j,points[i].distanceTo(points[j])));
			}
			Collections.sort(edges);
			boolean merged = false;
			for(Edge e:edges) if(find(e.u) != find(e.v)) {
				merge(e.u,e.v);
				merged = true;
				out.write((e.u + 1) + " " + (e.v + 1) + "\n");
			}
			if(!merged)	out.write("No new highways need.\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
		in.close();
		out.close();
	}
	static class Point {
		double x,y;
		Point(double x,double y) {this.x = x; this.y = y;}
		double distanceTo(Point p) {
			return Math.sqrt(Math.pow(x - p.x,2) + Math.pow(y - p.y,2));
		}
	}
	static class Edge implements Comparable<Edge> {
		int u,v;
		double dis;
		Edge(int u,int v,double dis) {this.u = u; this.v = v; this.dis = dis;}
		public int compareTo(Edge e) {return Double.compare(this.dis,e.dis);}
	}
	static int[] parent = new int[750];
	static int[] level = new int[750];
	static void clear() {
		for(int i = 0;i < 750;i++) {parent[i] = i; level[i] = 0;}
	}
	static int find(int p) {
		if(parent[p] == p)	return p;
		return parent[p] = find(parent[p]);
	}
	static void merge(int a,int b) {
		a = find(a);
		b = find(b);
		if(level[a] == level[b]) {parent[b] = a; level[a]++;}
		else if(level[a] > level[b])	parent[b] = a;
		else	parent[a] = b;
	}
}
