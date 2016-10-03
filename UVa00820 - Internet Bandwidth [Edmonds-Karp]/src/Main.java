import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int s,t,c,u,v,w,TC = 0;
		while((n = getInt()) != 0) {
			for(int[] each:graph)	Arrays.fill(each,0);
			s = getInt() - 1; t = getInt() - 1; c = getInt();
			while(c-- > 0) {
				graph[u = getInt() - 1][v = getInt() - 1] += w = getInt();
				graph[v][u] += w;
			}
			System.out.println("Network " + ++TC);
			System.out.println("The bandwidth is " + maxflow(s,t) + ".\n");
		}
	}
	static int n;
	static int[] parent = new int[100];
	static int[][] graph = new int[100][100];
	static int maxflow(int s,int t) {
		int v,w,ans = 0;
		while(bfs(s,t)) {
			w = Integer.MAX_VALUE;
			for(v = t;v != s;v = parent[v])	w = Math.min(w,graph[parent[v]][v]);
			ans += w;
			for(v = t;v != s;v = parent[v]) {
				graph[parent[v]][v] -= w;
				graph[v][parent[v]] += w;
			}
		}
		return ans;
	}
	static boolean bfs(int s,int t) {
		Queue<Integer> q = new LinkedList<Integer>();
		BitSet visited = new BitSet(graph.length);
		q.add(s);
		visited.set(s);
		while(!q.isEmpty()) {
			int u = q.poll();
			if(u == t)	return true;
			for(int i = 0;i < graph.length;i++)
				if(graph[u][i] > 0 && !visited.get(i)) {
					q.add(i);
					parent[i] = u;
					visited.set(i);
				}
		}
		return false;
	}
}
