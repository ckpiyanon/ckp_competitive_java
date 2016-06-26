import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return(int)st.nval;}
	static BitSet visited = new BitSet(10000);
	static void dijkstra(ArrayList<ArrayList<Edge>> graph,int[] stp,int s) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		Edge e;
		pq.add(new Edge(s,0));
		visited.clear();
		while(!pq.isEmpty()) {
			e = pq.poll();
			if(visited.get(e.v))	continue;
			visited.set(e.v);
			stp[e.v] = e.w;
			for(Edge ne:graph.get(e.v))	if(!visited.get(ne.v))
				pq.add(new Edge(ne.v,e.w + ne.w));
		}
	}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),n,m,s,t,p,u,v,c;
		int[] stp = new int[10000],stpr = new int[10000];
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(10000);
		ArrayList<ArrayList<Edge>> graphr = new ArrayList<ArrayList<Edge>>(10000);
		while(TC-- > 0) {
			n = getInt(); m = getInt(); s = getInt()-1; t = getInt()-1; p = getInt();
			for(int i = 0;i < n;i++) {
				if(graph.size() <= i) {
					graph.add(new ArrayList<Edge>());
					graphr.add(new ArrayList<Edge>());
				}
				graph.get(i).clear();
				graphr.get(i).clear();
			}
			while(m-- > 0) {
				u = getInt() - 1; v = getInt() - 1; c = getInt();
				graph.get(u).add(new Edge(v,c));
				graphr.get(v).add(new Edge(u,c));
			}
			Arrays.fill(stp,-1); dijkstra(graph,stp,s);
			Arrays.fill(stpr,-1); dijkstra(graphr,stpr,t);
			c = -1;
			for(u = 0;u < n;u++) for(Edge e:graph.get(u))
				if(stp[u] != -1 && stpr[e.v] != -1 && stp[u] + stpr[e.v] + e.w <= p)
					c = Math.max(c,e.w);
			System.out.println(c);
		}
	}
	static class Edge implements Comparable<Edge> {
		public int v,w;
		public Edge(int v,int w) {this.v = v; this.w = w;}
		public int compareTo(Edge e) {return w - e.w;}
	}
}
