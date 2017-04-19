import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0;i < 100;i++)	graph.add(new ArrayList<Integer>());
		int n,s,u,v,TC = 0;
		while((n = getInt()) != 0) {
			s = getInt() - 1;
			for(ArrayList<Integer> each:graph)	each.clear();
			Arrays.fill(dist,0);
			while((u = getInt()) != 0 & (v = getInt()) != 0)	graph.get(u - 1).add(v - 1);
			dfs(s);
			v = 0;
			for(int i = 0;i < n;i++) if(dist[i] > dist[v])	v = i;
			out.write("Case " + ++TC + ": The longest path from " + (s+1) + " has length " + dist[v] + ", finishing at " + (v+1) + ".\n\n");
		}
		out.flush();
	}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(100);
	static int[] dist = new int[100];
	static void dfs(int u) {
		for(Integer v:graph.get(u)) if(dist[u] + 1 > dist[v]) {
			dist[v] = dist[u] + 1;
			dfs(v);
		}
	}
}
