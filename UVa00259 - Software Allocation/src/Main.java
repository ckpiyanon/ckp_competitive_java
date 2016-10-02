import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int node(char c) {
		if(Character.isDigit(c))	return c - '0';
		return c - 'A' + 10;
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(in.ready()) {
			for(int[] each:graph)	Arrays.fill(each,0);
			while((s = in.readLine()) != null && s.length() > 0) {
				int task = node(s.charAt(0)),num = s.charAt(1) - '0';
				graph[SRC][task] += num;
				for(int i = 3;s.charAt(i) != ';';graph[task][node(s.charAt(i++))]++);
			}
			for(char ch = '0';ch <= '9';graph[node(ch++)][TAR] = 1);
			if(maxflow() > 0)	System.out.println("!");
			else {
				for(int i = 0;i < 10;i++) {
					boolean found = false;
					for(char ch = 'A';ch <= 'Z' && !found;ch++) if(graph[i][node(ch)] > 0) {
						System.out.print(ch); found = true;
					}
					if(!found)	System.out.print("_");
				}
				System.out.println();
			}
		}
	}
	static int maxflow() {
		int u,w,x = 0;
		for(char ch = 'A';ch <= 'Z';x += graph[SRC][node(ch++)]);
		while(bfs()) {
			w = Integer.MAX_VALUE;
			for(u = TAR;u != SRC;u = parent[u])	w = Math.min(w,graph[parent[u]][u]);
			for(u = TAR;u != SRC;u = parent[u]) {
				graph[parent[u]][u] -= w;	graph[u][parent[u]] += w;
			}
			x--;
		}
		return x;
	}
	static boolean bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		visited.clear(); visited.set(SRC); q.add(SRC);
		while(!q.isEmpty()) {
			int u = q.poll();
			if(u == TAR)	return true;
			for(int v = 0;v < V;v++) if(graph[u][v] > 0 && !visited.get(v)) {
				parent[v] = u;
				visited.set(v);
				q.add(v);
			}
		}
		return false;
	}
	static final int V = 38,SRC = 36,TAR = 37;
	static int graph[][] = new int[V][V],parent[] = new int[V];
	static BitSet visited = new BitSet(V);
}
