import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	// UVa01216 - The Bug Sensor Problem
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StreamTokenizer(in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Point> points = new ArrayList<Point>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int TC = getInt();
		while(TC-- > 0) {
			points.clear();
			edges.clear();
			int maxSet = getInt();
			int x,y;
			while((x = getInt()) != -1) {
				y = getInt();
				points.add(new Point(x,y));
			}
			for(int i = 0;i < points.size();i++) for(int j = i + 1;j < points.size();j++)
				edges.add(new Edge(i,j,points.get(i).distanceTo(points.get(j))));
			UnionFind uf = new UnionFind(points.size());
			Collections.sort(edges);
			double ecd = 0.0;
			for(Edge e:edges) if(uf.find(e.u) != uf.find(e.v)) {
				uf.merge(e.u,e.v);
				ecd = e.dis;
				if(uf.numSet == maxSet)
					break;
			}
			out.write((int)Math.ceil(ecd) + "\n");
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
	static class UnionFind {
		int numNode,numSet;
		int[] parent,level;
		UnionFind(int numNode) {
			this.numNode = numSet= numNode;
			parent = new int[numNode];
			level = new int[numNode];
			for(int i = 0;i < numNode;i++) {
				parent[i] = i;
				level[i] = 0;
			}
		}
		void merge(int a,int b) {
			a = find(a); b = find(b);
			if(a == b)	return;
			if(level[a] > level[b])
				parent[b] = a;
			else if(level[b] > level[a])
				parent[a] = b;
			else {
				parent[b] = a; level[a]++;
			}
			numSet--;
		}
		int find(int n) {
			if(n == parent[n])	return n;
			return parent[n] = find(parent[n]);
		}
	}
}
