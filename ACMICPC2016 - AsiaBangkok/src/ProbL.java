import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class ProbL {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("inL.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = getInt(),M = getInt();
		graph = new ArrayList<ArrayList<Edge>>(N);
		visited = new BitSet(N);
		X = new int[N]; Y = new int[N];
		for(int i = 0;i < N;i++)	graph.add(new ArrayList<Edge>());
		while(M-- > 0) {
			int u = getInt() - 1,v = getInt() - 1,dx = getInt(),dy = getInt();
			graph.get(u).add(new Edge(u,v,dx,dy));
			graph.get(v).add(new Edge(v,u,-dx,-dy));
		}
		bfs();
		for(int i = 0;i < N;i++)	out.write(X[i] + " " + Y[i] + "\n");
		out.flush(); out.close();
	}
	static void bfs() {
		Queue<Edge> q = new LinkedList<Edge>();
		visited.set(0); q.add(new Edge(0,0,0,0));
		while(!q.isEmpty()) {
			Edge e = q.poll();
			int u = e.u,v = e.v,dx = e.dx,dy = e.dy;
			X[v] = X[u] + dx; Y[v] = Y[u] + dy;
			for(Edge edge:graph.get(v)) if(!visited.get(edge.v)) {
				visited.set(edge.v); q.add(edge);
			}
		}
	}
	static ArrayList<ArrayList<Edge>> graph;
	static BitSet visited;
	static int[] X,Y;
	static class Edge {
		int u,v,dx,dy;
		public Edge(int uu,int vv,int xx,int yy) {u = uu; v = vv; dx = xx; dy = yy;}
	}
}
