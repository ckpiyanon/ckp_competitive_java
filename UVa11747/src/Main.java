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
		try {System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		new Main().run();
	}
	void run() throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		DisjointSet ds = new DisjointSet(1000);
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		ArrayList<Integer> removed = new ArrayList<Integer>();
		while(true) {
			int n = getInt(),m = getInt();
			if(n == 0 && m == 0)	break;
			edgeList.clear(); removed.clear(); ds.reset();
			while(m-- > 0)	edgeList.add(new Edge(getInt(),getInt(),getInt()));
			Collections.sort(edgeList);
			for(Edge e:edgeList) {
				if(!ds.isSameSet(e.u,e.v))
					ds.merge(e.u,e.v);
				else
					removed.add(e.w);
			}
			if(removed.size() == 0)
				System.out.println("forest");
			else
				System.out.println(removed.toString().replace("[","").replace("]","").replace(", "," "));
		}
	}
	class Edge implements Comparable<Edge>{
		public int u,v,w;
		public Edge(int u,int v,int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge e) {return this.w - e.w;}
	}
	class DisjointSet {
		public int[] ds,rank;
		public DisjointSet(int n) {
			ds = new int[n];
			rank = new int[n];
			reset();
		}
		public void reset() {
			for(int i = 0;i < ds.length;i++)	ds[i] = i;
			Arrays.fill(rank,0);
		}
		public int find(int x) {
			int tmp,root = x;
			while(ds[root] != root)	root = ds[root];
			while(x != root) {
				tmp = ds[x];
				ds[x] = root;
				x = tmp;
			}
			return root;
		}
		public void merge(int a,int b) {
			int x = find(a),y = find(b);
			if(x == y)	return;
			if(rank[x] > rank[y])
				ds[x] = y;
			else {
				ds[y] = x;
				if(rank[x] == rank[y])	rank[y]++;
			}
		}
		public boolean isSameSet(int a,int b) {return find(a) == find(b);}
	}
}
