import java.io.*;
import java.util.*;

public class probF_Prim {
	static class Edge implements Comparable<Edge> {
		public int to,w,c;
		public Edge(int to,int w,int c) {
			this.to = to;
			this.w = w;
			this.c = c;
		}
		public int compareTo(Edge a) {return this.w - a.w;}
		public void set(int to,int w,int c) {this.w = w; this.c = c;}
	}
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("probF.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] v = new boolean[100];
		for(int i = 0;i < 100;i++)	graph.add(new ArrayList<Edge>());
		int TC,n,ans,cost;
		Edge tmp;
		TC = getInt();
		while(TC-- > 0) {
			n = getInt();
			pq.clear();
			Arrays.fill(v,false);
			for(int i = 0;i < 100;i++)	graph.get(i).clear();
			for(int i = 0;i < n;i++)	for(int j = 0;j < n;j++)
				graph.get(i).add(new Edge(j,getInt(),getInt()));
			for(Edge e:graph.get(0))	if(e.w != 0)	pq.add(e);
			v[0] = true;
			ans = cost = 0;
			while(!pq.isEmpty()) {
				tmp = pq.poll();
				if(!v[tmp.to]) {
					v[tmp.to] = true;
					ans += tmp.w;
					cost += tmp.c;
					for(Edge e:graph.get(tmp.to))	if(e.w != 0)	pq.add(e);
				}
			}
			System.out.println(ans + " " + cost);
		}
	}
}
