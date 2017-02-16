import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Edge> graph = new ArrayList<Edge>();
		int r,u,v,TC = 0;
		while(getInt() != 0 && (r = getInt()) != 0) {
			graph.clear(); uf_init();
			while(r-- > 0)	graph.add(new Edge(getInt() - 1,getInt() - 1,getInt() - 1));
			Collections.sort(graph);
			u = getInt() - 1; v = getInt() - 1; r = getInt();
			for(Edge e:graph) {
				if(!connected(e.u,e.v))	merge(e.u,e.v);
				if(connected(u,v)) {
					out.write("Scenario #" + ++TC + "\nMinimum Number of Trips = " + (int)Math.ceil((double)(r) / e.w) + "\n\n");
					break;
				}
			}
		}
		out.flush();
	}
	
	static class Edge implements Comparable<Edge> {
		public int u,v,w;
		public Edge(int u,int v,int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge e) {return e.w - w;}
	}
	static int[] uf_p = new int[100];
	static int[] uf_r = new int[100];
	static void uf_init() {
		for(int i = 0;i < 100;i++)	uf_p[i] = i;
		Arrays.fill(uf_r,0);
	}
	static int find(int n) {
		int p = n,t;
		while((p = uf_p[p]) != uf_p[p]);
		while(n != uf_p[n]) {
			t = uf_p[n];
			uf_p[n] = p;
			n = t;
		}
		return p;
	}
	static void merge(int a,int b) {
		a = find(a); b = find(b);
		if(a == b)	return;
		if(uf_r[a] == uf_r[b]) {
			uf_p[a] = b;
			uf_r[b]++;
		}
		else if(uf_r[a] > uf_r[b])	uf_p[b] = a;
		else	uf_p[a] = b;
	}
	static boolean connected(int a,int b) {return find(a) == find(b);}
}
