import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static void bfs(int node) {
		Arrays.fill(v,2000000000);
		queue.clear();
		queue.add(node);
		v[node] = 0;
		while(!queue.isEmpty()) {
			node = queue.poll();
			for(int i: graph.get(node))
				if(v[i] > v[node] + 1) {
					v[i] = v[node] + 1;
					queue.add(i);
				}
		}
	}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N,a,b,nN,ans,TC = 0;
		for(int i = 0;i < 30;i++)	graph.add(new ArrayList<Integer>());
		while((N = getInt()) != 0) {
			for(int i = 0;i < 30;i++)	graph.get(i).clear();
			keys.clear();
			nN = 0;
			for(int i = 0;i < N;i++) {
				if(!keys.containsKey(a = getInt()))	keys.put(a,nN++);
				if(!keys.containsKey(b = getInt()))	keys.put(b,nN++);
				graph.get(keys.get(a)).add(keys.get(b));
				graph.get(keys.get(b)).add(keys.get(a));
			}
			while(true) {
				a = getInt();
				b = getInt();
				if(a == 0 && b == 0)	break;
				bfs(keys.get(a));
				ans = 0;
				for(int i = 0;i < nN;i++)	if(v[i] > b)	ans++;
				System.out.println("Case " + (++TC) + ": " + ans + " nodes not reachable from node " + a + " with TTL = " + b + ".");
			}
		}
	}
	static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));;
	static HashMap<Integer,Integer> keys = new HashMap<Integer,Integer>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[] v = new int[30];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
}