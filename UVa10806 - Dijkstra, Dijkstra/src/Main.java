import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static final int INF = 200000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int m,u,v,w;
		while((n = getInt()) != 0) {
			graph = new int[n][n];
			parent = new int[n];
			dis = new int[n];
			m = getInt();
			while(m-- > 0) {
				u = getInt() - 1; v = getInt() - 1; w = getInt();
				graph[u][v] = graph[v][u] = w;
			}
			boolean hasWay = true;
			int time = sssp(0,n-1);
			for(v = n-1;v != 0;v = parent[v]) {
				graph[parent[v]][v] = 0;
				graph[v][parent[v]] = -graph[v][parent[v]];
			}
			if(sssp(0,n-1) == INF)	hasWay = false;
			out.write(hasWay ? String.valueOf(time + dis[n-1]):"Back to jail");
			out.write("\n");
		}
		out.flush();
	}
	static int n;
	static int[] parent,dis;
	static int[][] graph;
	static int sssp(int s,int t) {
		Arrays.fill(dis,INF);
		dis[s] = 0;
		for(int iteration = 1;iteration < dis.length;iteration++)
			for(int u = 0;u < n;u++) for(int v = 0;v < n;v++)
				if(graph[u][v] != 0 && dis[v] > dis[u] + graph[u][v]) {
					dis[v] = dis[u] + graph[u][v];
					parent[v] = u;
				}
		return dis[t];
	}
	static class Edge {
		int u,v,w;
		public Edge(int u,int v,int w) {this.u = u; this.v = v; this.w = w;}
	}
}
