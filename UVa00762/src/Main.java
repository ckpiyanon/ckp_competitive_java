import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int x;
	static int getCity(String s) {
		Integer n = map.get(s);
		if(n != null) return n;
		map.put(s,x);
		return x++;
	}
	static int sssp(int u,int v) {
		visited.clear();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		Edge edge;
		pq.add(new Edge(u,u,0));
		while(!pq.isEmpty()) {
			edge = pq.poll();
			if(visited.get(edge.v)) continue;
			visited.set(edge.v,true);
			p[edge.v] = edge.u;
			if(edge.v == v) return edge.w;
			for(Integer e:graph[edge.v]) if(!visited.get(e))
				pq.add(new Edge(edge.v,e,edge.w + 1));
		}
		return -1;
	}
	static ArrayList<Integer> getPath(int u,int v,ArrayList<Integer> l) {
		while(true) {
			l.add(v);
			if(v == u) break;
			v = p[v];
		}
		return l;
	}
	static String getPath(ArrayList<Integer> path) {
		StringBuilder sb = new StringBuilder();
		for(int i = path.size() - 1;i > 0;i--)
			sb.append(cities[path.get(i)] + " " + cities[path.get(i-1)] + "\n");
		return sb.toString();
	}
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	static String[] cities = new String[1000];
	static BitSet visited = new BitSet(1000);
	static int[] p = new int[1000];
	@SuppressWarnings("unchecked") static ArrayList<Integer> graph[] = new ArrayList[1000];
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int i = 0;i < 1000;i++) graph[i] = new ArrayList<Integer>();
		int n,u,v;
		while(in.ready()) {
			n = Integer.parseInt(in.readLine());
			x = 0;
			map.clear();
			for(List<Integer> a:graph) a.clear();
			while(n-- > 0) {
				String s = in.readLine();
				st = new StringTokenizer(s);
				u = getCity(st.nextToken());
				v = getCity(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}
			st = new StringTokenizer(in.readLine());
			u = getCity(st.nextToken());
			v = getCity(st.nextToken());
			for(Map.Entry<String,Integer> entry:map.entrySet())
				cities[entry.getValue()] = entry.getKey();
			if(sssp(u,v) != -1)
				out.write(getPath(getPath(u,v,new ArrayList<Integer>())));
			else out.write("No route\n");
			in.readLine();
			if(in.ready()) out.write("\n");
			out.flush();
		}
	}
	static class Edge implements Comparable<Edge> {
		public int u,v,w;
		public Edge(int u,int v,int w) {this.u = u; this.v = v; this.w = w;}
		public int compareTo(Edge o) {return this.w - o.w;}
	}
}
