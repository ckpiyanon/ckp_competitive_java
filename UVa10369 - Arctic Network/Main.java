import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	// UVa10369 - Arctic Network
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StreamTokenizer(in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		DecimalFormat df = new DecimalFormat("0.00");
		Point[] points = new Point[500];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int TC = getInt();
		while(TC-- > 0) {
			int s = getInt(),p = getInt();
			for(int i = 0;i < p;i++)
				points[i] = new Point(getInt(),getInt());
			clear();
			edges.clear();
			numSet = p;
			for(int i = 0;i < p;i++) for(int j = i + 1;j < p;j++)
				edges.add(new Edge(i,j,points[i].distanceTo(points[j])));
			Collections.sort(edges);
			double maxDist = 0.0;
			for(Edge e:edges) {
				if(numSet == s)	break;
				if(find(e.u) != find(e.v)) {
					maxDist = e.dis;
					merge(e.u,e.v);
				}
			}
			out.write(df.format(maxDist) + "\n");
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
	static int numSet;
	static int[] parent = new int[500];
	static int[] level = new int[500];
	static void clear() {
		for(int i = 0;i < 500;i++) {parent[i] = i; level[i] = 0;}
	}
	static int find(int p) {
		if(parent[p] == p)	return p;
		return parent[p] = find(parent[p]);
	}
	static void merge(int a,int b) {
		a = find(a);
		b = find(b);
		if(a == b)	return;
		numSet--;
		if(level[a] == level[b]) {parent[b] = a; level[a]++;}
		else if(level[a] > level[b])	parent[b] = a;
		else	parent[a] = b;
	}
}
