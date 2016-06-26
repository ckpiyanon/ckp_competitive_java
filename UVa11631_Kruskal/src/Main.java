import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	StreamTokenizer st;
	int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		new Main().run();
	}
	void run() throws Exception {
		int m,n,total,tmp;
		DisjointSet set = new DisjointSet(200000);
		ArrayList<Edge> list = new ArrayList<Edge>();
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(true) {
			m = getInt(); n = getInt();
			if(m == 0 && n == 0) break;
			list.clear();
			set.reset();
			total = 0;
			while(n-- > 0) {
				list.add(new Edge(getInt(),getInt(),tmp = getInt()));
				total += tmp;
			}
			Collections.sort(list);
			n = 0;
			for(Edge e: list) if(!set.isSameSet(e.u,e.v)) {
				set.merge(e.u,e.v);
				n += e.w;
			}
			System.out.println(total - n);
		}
	}
	class Edge implements Comparable<Edge> {
		public int u,v,w;
		public int compareTo(Edge e) {return this.w - e.w;}
		public Edge(int u,int v,int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	class DisjointSet {
		public int[] ds;
		public DisjointSet(int n) {
			ds = new int[n];
			this.reset();
		}
		public void reset() {
			for(int i = 0;i < ds.length;i++)
				ds[i] = i;
		}
		public int find(int n) {
			int tmp,root = n;
			while(root != ds[root])	root = ds[root];
			while(n != ds[n]) {
				tmp = ds[n];
				ds[n] = root;
				n = tmp;
			}
			return root;
		}
		public void merge(int a,int b) {
			int x = find(a),y = find(b);
			ds[x] = y;
		}
		public boolean isSameSet(int a,int b) {return find(a) == find(b);}
	}
}
