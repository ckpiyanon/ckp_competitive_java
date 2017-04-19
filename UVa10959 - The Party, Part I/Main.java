import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt(),u,v,p,d;
		for(int i = 0;i < 1000;i++)	graph.add(new ArrayList<Integer>());
		while(TC-- > 0) {
			for(ArrayList<Integer> each:graph)	each.clear();
			p = getInt(); d = getInt();
			while(d-- > 0) {
				u = getInt(); v = getInt();
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			bfs();
			for(int i = 1;i < p;i++)	out.write(w[i] + "\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(1000);
	static int[] w = new int[1000];
	static void bfs() {
		Arrays.fill(w,-1);
		Queue<Edge> q = new LinkedList<Edge>();
		w[0] = 0; q.add(new Edge(0,0));
		while(!q.isEmpty()) {
			Edge e = q.poll();
			for(Integer v:graph.get(e.v)) if(w[v] == -1) {
				w[v] = e.w + 1;
				q.add(new Edge(v,e.w + 1));
			}
		}
	}
	static class Edge {
		int v,w;
		Edge(int vv,int ww) {v = vv; w = ww;}
	}
}
