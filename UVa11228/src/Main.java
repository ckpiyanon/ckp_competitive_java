import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.PriorityQueue;

public class Main {
	StreamTokenizer st;
	int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	double dist(double x1,double y1,double x2,double y2) {
		return Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2));
	}
	public static void main(String args[]) throws Exception {
		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		new Main().run();
	}
	ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
	int n,r,numRail;
	double distRoad,distRail;
	void run() throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),TC_ = 0;
		int[] x = new int[1000],y = new int[1000];
		for(int i = 0;i < 1000;i++)	list.add(new ArrayList<Edge>());
		while(TC_++ < TC) {
			n = getInt(); r = getInt();
			for(ArrayList<Edge> a:list)	a.clear();
			for(int i = 0;i < n;i++) {
				x[i] = getInt(); y[i] = getInt();
			}
			for(int i = 0;i < n;i++)
				for(int j = 0;j < n;j++)
					list.get(i).add(new Edge(j,dist(x[i],y[i],x[j],y[j])));
			numRail = 0;
			distRoad = distRail = 0.0;
			prim();
			distRoad = Math.round(distRoad);
			distRail = Math.round(distRail);
			System.out.printf("Case #%d: %d %d %d\n",TC_,numRail + 1,(int)distRoad,(int)distRail);
		}
	}
	void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		BitSet visited = new BitSet(n);
		visited.set(0,true);
		pq.addAll(list.get(0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited.get(e.v))	continue;
			visited.set(e.v,true);
			if(e.w >= r) {
				numRail++;
				distRail += e.w;
			}
			else	distRoad += e.w;
			pq.addAll(list.get(e.v));
		}
	}
	class Edge implements Comparable<Edge>{
		public int v;
		double w;
		public Edge(int v,double w) {
			this.v = v; this.w = w;
		}
		public int compareTo(Edge e) {
			return Double.valueOf(this.w).compareTo(e.w);
		}
	}
}
