import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		ArrayList<Edge> list = new ArrayList<Edge>();
		ArrayList<Integer> used = new ArrayList<Integer>();
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),n,m,t,t0,ans;
		while(TC-- > 0) {
			n = getInt(); m = getInt();	list.clear();
			while(m-- > 0)	list.add(new Edge(getInt() - 1,getInt() - 1,getInt()));
			Collections.sort(list);
			used.clear();
			t = 0;
			uf_init(n);
			for(int i = 0;i < list.size();i++) {
				Edge e = list.get(i);
				if(uf_find(e.u) == uf_find(e.v))	continue;
				used.add(i);
				t += e.w;
				uf_join(e.u,e.v);
				if(uf_size == 1)	break;
			}
			System.out.print(t + " ");
			ans = Integer.MAX_VALUE;
			for(int k = 0;k < used.size();k++) {
				uf_init(n);	t0 = 0;
				for(int i = 0;i < list.size();i++) {
					if(i == used.get(k))	continue;
					Edge e = list.get(i);
					if(uf_find(e.u) == uf_find(e.v))	continue;
					t0 += e.w;
					uf_join(e.u,e.v);
					if(uf_size == 1) {
						ans = Math.min(t0,ans);
						break;
					}
				}
			}
			System.out.println(ans);
		}
	}
	// Union-Find Disjoint Set
	static int uf_size;
	static int[] uf_parent = new int[100];
	static int uf_find(int n) {
		return uf_parent[n] = n == uf_parent[n] ? n:uf_find(uf_parent[n]);
	}
	static void uf_init(int n) {
		uf_size = n;
		for(int i = 0;i < 100;i++)
			uf_parent[i] = i;
	}
	static void uf_join(int a,int b) {
		a = uf_find(a); b = uf_find(b);
		if(a == b)	return;
		uf_parent[a] = b;
		uf_size--;
	}
	
	static class Edge implements Comparable<Edge> {
		int u,v,w;
		public Edge(int u,int v,int w) {this.u = u; this.v = v; this.w = w;}
		public int compareTo(Edge e) {return w - e.w;}
	}
}
