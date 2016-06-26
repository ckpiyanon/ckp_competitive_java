import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static String getString() throws Exception {
		st.nextToken();
		return st.sval;
	}
	public static void main(String args[]) throws Exception {
//		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tmp,TC = getInt(),m,n;
		String s1,s2;
		while(TC-- > 0) {
			m = getInt(); n = getInt();
			tmp = 0;
			map.clear();
			graph.clear();
			as.clear();
			for(int i = 0;i < m;i++) {
				s1 = getString(); s2 = getString();
				if(!map.containsKey(s1)) {
					map.put(s1,tmp++);
					as.add(s1);
					graph.add(new ArrayList<Integer>());
				}
				if(!map.containsKey(s2)) {
					map.put(s2,tmp++);
					as.add(s2);
					graph.add(new ArrayList<Integer>());
				}
				graph.get(map.get(s1)).add(map.get(s2));
				graph.get(map.get(s2)).add(map.get(s1));
			}
			while(n-- > 0) {
				out.write(dijkstra(getString(),getString()));
				out.write("\n");
			}
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	static ArrayList<String> as = new ArrayList<String>();
	static String dijkstra(String src,String des) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		BitSet visited = new BitSet(as.size());
		int from[] = new int[as.size()];
		int u = map.get(src);
		visited.set(u,true);
		for(Integer v:graph.get(u))	pq.add(new Edge(u,v,1));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited.get(e.v))	continue;
			from[e.v] = e.u;
			visited.set(e.v,true);
			for(Integer v:graph.get(e.v))	pq.add(new Edge(e.v,v,e.w + 1));
		}
		int dint = map.get(des);
		StringBuilder sb = new StringBuilder();
		while(dint != map.get(src)) {
			sb.append(as.get(dint).charAt(0));
			dint = from[dint];
		}
		sb.append(src.charAt(0));
		return sb.reverse().toString();
	}
	static class Edge implements Comparable<Edge> {
		public int u,v,w;
		public Edge(int u,int v,int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge e) {return w - e.w;}
	}
}
