import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static final int INF = 1000000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),n,m,d[] = new int[1000];
		boolean hasNeg;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		while(TC-- > 0) {
			edges.clear();
			Arrays.fill(d,INF);
			d[0] = 0;
			n = getInt(); m = getInt();
			while(m-- > 0) edges.add(new Edge(getInt(),getInt(),getInt()));
			for(int i = 1;i < n;i++)
				for(Edge e:edges)
					d[e.v] = Math.min(d[e.v],d[e.u] + e.w);
			hasNeg = false;
			for(Edge e:edges)
				if(d[e.v] > d[e.u] + e.w) {
					hasNeg = true;
					break;
				}
			System.out.println(hasNeg ? "possible":"not possible");
		}
	}
	static class Edge {
		public int u,v,w;
		public Edge(int u,int v,int w) {this.u = u; this.v = v; this.w = w;}
	}
}
