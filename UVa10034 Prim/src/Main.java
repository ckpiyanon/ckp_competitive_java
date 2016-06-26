import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static double getDouble() throws Exception {st.nextToken(); return st.nval;}
	static int getInt() throws Exception {return (int)getDouble();}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(100);
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		BitSet visited = new BitSet(100);
		int TC = getInt(),n;
		double total;
		boolean first = true;
		for(int i = 0;i < 100;i++)	graph.add(new ArrayList<Edge>());
		while(TC-- > 0) {
			n = getInt();	pairs.clear();
			for(int i = 0;i < n;i++)	graph.get(i).clear();
			while(n-- > 0)	pairs.add(new Pair(getDouble(),getDouble()));
			for(int i = 0;i < pairs.size();i++) for(int j = i + 1;j < pairs.size();j++) {
				graph.get(i).add(new Edge(j,pairs.get(i).distance(pairs.get(j))));
				graph.get(j).add(new Edge(i,pairs.get(j).distance(pairs.get(i))));
			}
			total = 0;
			visited.clear();
			visited.set(0,true);
			pq.addAll(graph.get(0));
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(visited.get(e.v))	continue;
				visited.set(e.v,true);
				total += e.w;
				for(Edge ne:graph.get(e.v)) if(!visited.get(ne.v))
					pq.add(ne);
			}
			if(!first)	System.out.println();
			first = false;
			System.out.printf("%.2f\n",total);
		}
	}
	
	static class Pair {
		public double x,y;
		public Pair(double x,double y) {this.x = x; this.y = y;}
		public double distance(Pair p) {
			return Math.sqrt(Math.pow(x - p.x,2) + Math.pow(y - p.y,2));
		}
	}
	
	static class Edge implements Comparable<Edge> {
		public int v;
		public double w;
		public Edge(int v,double w) {this.v = v; this.w = w;}
		public int compareTo(Edge e) {return Double.compare(w,e.w);}
	}
}
