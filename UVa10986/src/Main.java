import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	@SuppressWarnings("unchecked")
	static ArrayList<Edge> graph[] = new ArrayList[20000];
	static BitSet visited = new BitSet(20000);
	static int sssp() {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		Edge v;
		visited.clear(); pq.add(new Edge(s,0));
		while(!pq.isEmpty()) {
			v = pq.poll();
			if(visited.get(v.v))	continue;
			visited.set(v.v,true);
			if(v.v == t)	return v.w;
			for(Edge e:graph[v.v])	if(!visited.get(e.v))
				pq.add(new Edge(e.v,e.w + v.w));
		}
		return -1;
	}
	static int n,m,s,t;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),u,v,w;
		for(int i = 0;i < 20000;i++)	graph[i] = new ArrayList<Edge>();
		for(int x = 1;x <= TC;x++) {
			n = getInt(); m = getInt(); s = getInt(); t = getInt();
			for(int i = 0;i < n;i++)	graph[i].clear();
			while(m-- > 0) {
				u = getInt(); v = getInt(); w = getInt();
				graph[u].add(new Edge(v,w));
				graph[v].add(new Edge(u,w));
			}
			System.out.println("Case #" + x + ": " + ((w = sssp()) == -1 ? "unreachable":w));
		}
	}
	static class Edge implements Comparable<Edge> {
		public int v,w;
		public int compareTo(Edge e) {return w - e.w;}
		public Edge(int v,int w) {this.v = v; this.w = w;}
	}
}
