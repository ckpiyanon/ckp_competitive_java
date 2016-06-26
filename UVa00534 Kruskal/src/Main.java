import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static int n;
	static ArrayList<Edge> list = new ArrayList<Edge>();
	static double distance(double x1,double y1,double x2,double y2) {
		return Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2));
	}
	static double mst() {
		DisjointSet ds = new DisjointSet(n);
		for(Edge e:list) {
			if(ds.isSameSet(e.u,e.v))	continue;
			ds.merge(e.u,e.v);
			if(ds.isSameSet(0,1))	return e.w;
		}
		return list.get(list.size() - 1).w;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in_.txt"));
		int TC = 1;
		int[] x,y;
		x = new int[200]; y = new int[200];
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(true) {
			n = getInt();
			if(n == 0)	break;
			list.clear();
			for(int i = 0;i < n;i++) {
				x[i] = getInt(); y[i] = getInt();
			}
			for(int i = 0;i < n;i++)
				for(int j = i + 1;j < n;j++)
					list.add(new Edge(i,j,distance(x[i],y[i],x[j],y[j])));
			Collections.sort(list);
			System.out.printf("Scenario #%d\nFrog Distance = %.3f\n\n",TC++,mst());
		}
	}
	static class DisjointSet {
		private int ds[],rank[];
		public DisjointSet(int n) {
			ds = new int[n];
			rank = new int[n];
			for(int i = 0;i < n;i++)	ds[i] = i;
			Arrays.fill(rank,0);
		}
		public int find(int n) {
			int root,tmp;
			root = n;
			while(ds[root] != root)	root = ds[root];
			while(n != root) {
				tmp = ds[n];
				ds[n] = root;
				n = tmp;
			}
			return root;
		}
		public void merge(int a,int b) {
			int x = find(a),y = find(b);
			if(x == y)	return;
			if(rank[x] > rank[y]) {
				ds[x] = y;
			}
			else {
				ds[y] = x;
				if(rank[x] == rank[y])	rank[x]++;
			}
		}
		public boolean isSameSet(int a,int b) {return find(a) == find(b);}
	}
	static class Edge implements Comparable<Edge> {
		public int u,v;
		public double w;
		public Edge(int u,int v,double w) {
			this.u = u; this.v = v; this.w = w;
		}
		public int compareTo(Edge e) {return Double.valueOf(this.w).compareTo(new Double(e.w));}
	}
}