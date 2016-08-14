import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		new Main().run();
	}
	ArrayList<ArrayList<Integer>> graph;
	void run() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		ArrayList<String> arr = new ArrayList<String>();
		graph = new ArrayList<ArrayList<Integer>>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String s1,s2;
		StringTokenizer st;
		for(int i = 0;i < 210;i++)	graph.add(new ArrayList<Integer>());
		in.readLine();
		while(TC-- > 0) {
			arr.clear();
			map.clear();
			for(ArrayList<Integer> a:graph)	a.clear();
			while(!(s1 = in.readLine()).equals("*"))
				arr.add(s1);
			Collections.sort(arr,new Comparator<String>() {
				public int compare(String a,String b) {return a.length() - b.length();}
			});
			for(int i = 0;i < arr.size();i++)	map.put(arr.get(i),i);
			for(int i = 0;i < arr.size();i++) for(int j = i + 1;j < arr.size();j++) {
				s1 = arr.get(i);
				s2 = arr.get(j);
				if(s1.length() != s2.length())	break;
				if(diff(s1,s2)) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
			while(true) {
				s1 = in.readLine();
				if(s1 == null || s1.equals(""))	break;
				st = new StringTokenizer(s1);
				System.out.println(s1 + " " + dijkstra(map.get(st.nextToken()),map.get(st.nextToken())));
			}
			if(TC > 0)	System.out.println();
		}
	}
	int dijkstra(int src,int tar) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean visited[] = new boolean[210];
		for(int i = 0;i < graph.get(src).size();i++)	pq.add(new Edge(1,graph.get(src).get(i)));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.v])	continue;
			if(e.v == tar)	return e.w;
			visited[e.v] = true;
			for(int i = 0;i < graph.get(e.v).size();i++)
				pq.add(new Edge(e.w + 1,graph.get(e.v).get(i)));
		}
		return 0;
	}
	class Edge implements Comparable<Edge> {
		public int w,v;
		public Edge(int w,int v) {
			this.w = w;
			this.v = v;
		}
		public int compareTo(Edge e) {return this.w - e.w;}
	}
	boolean diff(String s1,String s2) {
		if(s1.length() != s2.length())	return false;
		boolean n = false;
		for(int i = 0;i < s1.length();i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(!n)	n = true;
				else	return false;
			}
		}
		return true;
	}
}
