import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	StreamTokenizer st;
	ArrayList<ArrayList<Edge>> graph;
	int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));}catch(Exception e) {}
		new Main().run();
	}
	void run() throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt();
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i = 0;i < 100;i++)	graph.add(new ArrayList<Edge>());
		while(TC-- > 0) {
			int N = getInt(),E = getInt()-1,T = getInt(),M = getInt();
			for(int i = 0;i < N;i++)	graph.get(i).clear();
			while(M-- > 0)	graph.get(getInt()-1).add(new Edge(getInt()-1,getInt()));
			int num = 0;
			for(int i = 0;i < N;i++) if(dijkstra(i,T,E)) num++;
			System.out.println(num);
			if(TC > 0)	System.out.println();
		}
	}
	boolean dijkstra(int src,int time,int des) {
		if(src == des && time >= 0)	return true;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.addAll(graph.get(src));
		Edge e;
		while(!pq.isEmpty()) {
			e = pq.poll();
			if(e.w > time)	return false;
			if(e.v == des)	return true;
			for(Edge x:graph.get(e.v))	pq.add(new Edge(x.v,e.w + x.w));
		}
		return false;
	}
	class Edge implements Comparable<Edge> {
		public int v,w;
		public Edge(int v,int w) {
			this.v = v; this.w = w;
		}
		public int compareTo(Edge e) {return this.w - e.w;}
	}
}
