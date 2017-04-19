import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
//		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		DisjointSet ds;
		ArrayList<Edge> list = new ArrayList<Edge>();
		int N,total;
		boolean first = true;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			list.clear();
			ds = new DisjointSet(N = (int)st.nval);
			if(!first)	System.out.println();
			first = false;
			total = 0;
			while(--N > 0) {
				getInt(); getInt(); total += getInt();
			}
			System.out.println(total);
			N = getInt();
			while(N-- > 0)	list.add(new Edge(getInt() - 1,getInt() - 1,getInt()));
			N = getInt();
			while(N-- > 0)	list.add(new Edge(getInt() - 1,getInt() - 1,getInt()));
			Collections.sort(list); total = 0;
			for(Edge e:list) {
				if(ds.isSameSet(e.u,e.v))	continue;
				total += e.w;
				ds.merge(e.u,e.v);
				if(ds.size() == 1)	break;
			}
			System.out.println(total);
		}
	}
	static class DisjointSet {
		int[] ds;
		int size;
		public DisjointSet(int n) {
			ds = new int[n];
			for(int i = 0;i < n;i++)	ds[i] = i;
			size = n;
		}
		public int size() {return size;}
		public int find(int n) {
			int root = n,tmp;
			while(root != ds[root])	root = ds[root];
			tmp = n;
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
			size--;
			ds[x] = y;
		}
		public boolean isSameSet(int a,int b) {return find(a) == find(b);}
	}
	static class Edge implements Comparable<Edge> {
		public int u,v,w;
		public Edge(int u,int v,int w) {
			this.u = u; this.v = v; this.w = w;
		}
		public int compareTo(Edge e) {return this.w - e.w;}
	}
}
