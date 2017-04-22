import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0;i < 44;i++)	graph.add(new ArrayList<>());
		int u,v,n,src = 0;
		boolean odd;
		while((u = getInt()) != 0 | (v = getInt()) != 0) {
			for(ArrayList<Edge> each:graph)	each.clear();
			Arrays.fill(used,false);
			max = 0;
			odd = true;
			n = -1;
			do {
				if(n == -1)	src = Math.min(u,v) - 1;
				n = getInt() - 1;
				max = Math.max(n,max);
				graph.get(u-1).add(new Edge(v-1,n));
				graph.get(v-1).add(new Edge(u-1,n));
			} while((u = getInt()) != 0 | (v = getInt()) != 0);
			for(ArrayList<Edge> each:graph) {
				Collections.sort(each);
				odd &= each.size() % 2 == 0;
			}
			visit.clear();
			if(odd) {
				dfs(src);
				out.write(visit.toString().replaceAll("[\\[\\],]","") + "\n\n");
			}
			else	out.write("Round trip does not exist.\n\n");
		}
		out.flush();
	}
	static int max;
	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>(44);
	static Deque<Integer> visit = new LinkedList<>();
	static void dfs(int u) {
		for(Edge e:graph.get(u)) if(!used[e.n]) {
			used[e.n] = true;
			dfs(e.v);
			visit.addFirst(e.n + 1);
		}
	}
	static boolean[] used = new boolean[1996];
	static class Edge implements Comparable<Edge> {
		public int v,n;
		public Edge(int vv,int nn) {v = vv; n = nn;}
		public int compareTo(Edge e) {return n - e.n;}
	}
}
