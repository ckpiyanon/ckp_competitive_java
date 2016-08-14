import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken();return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		boolean first = true;
		int N,total,u,v,w;
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		BitSet visited = new BitSet(1000000);
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			N = (int)st.nval;
			if(!first)	System.out.println();
			first = false;
			total = 0;
			for(int i = 0;i < N;i++) {
				if(graph.size() <= i)	graph.add(new ArrayList<Edge>());
				graph.get(i).clear();
			}
			while(--N > 0) {
				getInt(); getInt();
				total += getInt();
			}
			System.out.println(total);
			N = getInt();
			while(N-- > 0) {
				u = getInt()-1; v = getInt()-1; w = getInt();
				graph.get(u).add(new Edge(v,w));
				graph.get(v).add(new Edge(u,w));
			}
			N = getInt();
			while(N-- > 0) {
				u = getInt()-1; v = getInt()-1; w = getInt();
				graph.get(u).add(new Edge(v,w));
				graph.get(v).add(new Edge(u,w));
			}
			visited.clear(); pq.clear(); total = 0;
			visited.set(0,true); pq.addAll(graph.get(0));
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(visited.get(e.v))	continue;
				visited.set(e.v,true);
				total += e.w;
				for(Edge ne:graph.get(e.v)) if(!visited.get(ne.v))
					pq.add(ne);
			}
			System.out.println(total);
		}
	}
	static class Edge implements Comparable<Edge> {
		public int v,w;
		public Edge(int v,int w) {
			 this.v = v; this.w = w;
		}
		public int compareTo(Edge e) {return this.w - e.w;}
	}
}
