import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int SZ = 5000;
	static Map<String,Integer> map = new HashMap<String,Integer>();
	static int getNum(String s) {
		if(map.containsKey(s))	return map.get(s);
		int n = map.size();
		map.put(s,n);
		return n;
	}
	static List<Integer> computeList(String s) {
		List<Integer> list = new ArrayList<Integer>();
		char cs[] = s.toCharArray();
		int l,r;
		boolean first = true;
		l = r = 0;
		for(int i = 0;i < cs.length;i++) {
			if(cs[i] == ',') {
				if(!first) {
					r = i;
					list.add(getNum(new String(cs,l,r - l)));
					l = r + 2;
				}
				first = !first;
			}
		}
		list.add(getNum(new String(cs,l,cs.length - l)));
		return list;
	}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(SZ);
	static int weight[] = new int[SZ];
	static void bfs() {
		Queue<Edge> q = new LinkedList<Edge>();
		Arrays.fill(weight,-1);
		Edge e;
		q.add(new Edge(0,0));
		while(!q.isEmpty()) {
			e = q.poll();
			if(weight[e.v] > -1)	continue;
			weight[e.v] = e.w;
			for(int v:graph.get(e.v)) if(weight[v] == -1)
				q.add(new Edge(v,e.w + 1));
		}
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> list;
		String s;
		int TC = Integer.parseInt(in.readLine()),TC_ = 0,p,n;
		for(int i = 0;i < SZ;i++)	graph.add(new ArrayList<Integer>());
		while(TC-- > 0) {
			map.clear();	map.put("Erdos, P.",0);
			for(ArrayList<Integer> l:graph)	l.clear();
			st = new StringTokenizer(in.readLine());
			p = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			while(p-- > 0) {
				st = new StringTokenizer(in.readLine(),":");
				list = computeList(st.nextToken());
				for(int i = 0;i < list.size();i++) for(int j = 0;j < list.size();j++) {
					if(i == j)	continue;
					graph.get(list.get(i)).add(list.get(j));
				}
			}
			bfs();
			System.out.println("Scenario " + ++TC_);
			while(n-- > 0) {
				s = in.readLine();
				p = getNum(s);
				System.out.println(s + " " + (weight[p] == -1 ? "infinity":weight[p]));
			}
		}
	}
	static class Edge {
		public int v,w;
		public Edge(int v,int w) {this.v = v; this.w = w;}
	}
}
