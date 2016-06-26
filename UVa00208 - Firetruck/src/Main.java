import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Stack;

public class Main {
	static StreamTokenizer st;
	static int n,numPath;
	static ArrayList<ArrayList<Integer>> graph;
	static Stack<Integer> snapshot;
	static BitSet visited;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static void dfs(int u) {
		snapshot.add(u);
		if(u == n) {
			numPath++;
			System.out.println(snapshot.toString().replace("[","").replace("]","").replace(", "," "));
			snapshot.pop();
			return;
		}
		visited.set(u,true);
		for(Integer v: graph.get(u)) {
			if(!visited.get(v))	dfs(v);
		}
		visited.set(u,false);
		snapshot.pop();
	}
	static boolean hasPath(int s,int t) {
		visited.set(s,true);
		if(s == t)	return true;
		for(Integer v:graph.get(s)) if(!visited.get(v) && hasPath(v,t))
			return true;
		return false;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		int TC = 0,u,v;
		snapshot = new Stack<Integer>();
		graph = new ArrayList<>();
		visited = new BitSet(21);
		for(int i = 0;i <= 20;i++)	graph.add(new ArrayList<Integer>());
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval;
			System.out.println("CASE " + ++TC + ":");
			for(ArrayList<Integer> e: graph)	e.clear();
			while((u = getInt()) > 0 & (v = getInt()) > 0) {
				graph.get(u).add(v); graph.get(v).add(u);
			}
			for(int i = 1;i <= n;i++)	Collections.sort(graph.get(i));
			visited.clear();
			numPath = 0;
			if(hasPath(1,n)) {
				visited.clear();
				snapshot.clear();
				dfs(1);
			}
			System.out.println("There are " + numPath + " routes from the firestation to streetcorner " + n + ".");
		}
	}
}
