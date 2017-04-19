import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	StreamTokenizer st;
	int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		new Main().run();
	}
	void run() throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		DisjointSet ds;
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		int TC = getInt(),n,m,a,u,v,w,sum,min;
		for(int TC_ = 1;TC_ <= TC;TC_++) {
			n = getInt(); m = getInt(); a = getInt();
			ds = new DisjointSet(n);
			edgeList.clear();
			for(int i = 0;i < m;i++) {
				u = getInt() - 1; v = getInt() - 1; w = getInt();
				edgeList.add(new Edge(u,v,w));
			}
			Collections.sort(edgeList);
			sum = 0;
			min = Integer.MAX_VALUE;
			for(Edge e:edgeList) {
				if(ds.find(e.u) == ds.find(e.v))	continue;
				sum += e.w;
				ds.merge(e.v,e.u);
				if(min > sum + a*ds.numSet) {
					min = sum + a*ds.numSet;
					n = ds.numSet;
				}
			}
			System.out.println("Case #" + TC_ + ": " + min + " " + n);
		}
	}
	class Edge implements Comparable<Edge> {
		public int u,v,w;
		public Edge(int u,int v,int w) {this.u = u; this.v = v; this.w = w;}
		public int compareTo(Edge e) {return w - e.w;}
	}
	class DisjointSet {
		public int ds[],rank[],numSet;
		public DisjointSet(int n) {
			numSet = n;
			ds = new int[n];
			rank = new int[n];
			reset();
		}
		public void reset() {
			numSet = ds.length;
			for(int i = 0;i < numSet;i++)	ds[i] = i;
			Arrays.fill(rank,0);
		}
		public int find(int n) {
			int root = n,tmp;
			while(root != ds[root])	root = ds[root];
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
			numSet--;
			if(rank[x] > rank[y])
				ds[y] = x;
			else {
				ds[x] = y;
				if(rank[x] == rank[y])	rank[y]++;
			}
		}
	}
}
