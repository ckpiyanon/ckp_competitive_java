import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Edge> list = new ArrayList<Edge>();
		StringTokenizer st;
		int x,n,TC = Integer.parseInt(in.readLine()),TC_ = 0;
		while(TC-- > 0) {
			list.clear();
			uf_init(n = Integer.parseInt(in.readLine()));
			for(int i = 0;i < n;i++) {
				st = new StringTokenizer(in.readLine()," ,");
				for(int j = 0;j <= i;j++) {
					x = Integer.parseInt(st.nextToken());
					if(x != 0)	list.add(new Edge(j,i,x));
				}
			}
			System.out.println("Case " + ++TC_ + ":");
			Collections.sort(list);
			for(Edge e:list) {
				if(!uf_same(e.u,e.v)) {
					uf_join(e.u,e.v);
					System.out.println(e);
				}
				if(uf_size == 1)	break;
			}
		}
	}
	
	static int uf_size;
	static int[] uf_r = new int[26];
	static int[] uf_p = new int[26];
	static void uf_init(int n) {
		Arrays.fill(uf_r,0);
		for(int i = 0;i < 26;i++)	uf_p[i] = i;
		uf_size = n;
	}
	static boolean uf_same(int a,int b) {return uf_find(a) == uf_find(b);}
	static void uf_join(int a,int b) {
		a = uf_find(a); b = uf_find(b);
		if(a == b)	return;
		if(uf_r[a] > uf_r[b])
			uf_p[b] = a;
		else if(uf_r[b] > uf_r[a])
			uf_p[a] = b;
		else {
			uf_p[b] = a;
			uf_r[a]++;
		}
		uf_size--;
	}
	static int uf_find(int n) {
		int t,p = n;
		while((p = uf_p[p]) != uf_p[p]);
		while(n != p) {
			t = uf_p[n];
			uf_p[n] = p;
			n = t;
		}
		return p;
	}
	
	static class Edge implements Comparable<Edge> {
		public int u,v,w;
		public Edge(int u,int v,int w) {this.u = u; this.v = v; this.w = w;}
		public int compareTo(Edge e) {
			if(w == e.w) {
				if(u == e.u)	return v - e.v;
				return u - e.u;
			}
			return w - e.w;
		}
		public String toString() {
			return (char)(u + 'A') + "-" + (char)(v + 'A') + " " + w;
		}
	}
}
