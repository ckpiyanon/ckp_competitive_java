import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	/*INPUT*/
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	/*VERTEX DEALING*/
	static HashMap<String,Integer> map;
	static int X;
	static int getVertex(String s) {
		if(map.containsKey(s))	return map.get(s);
		map.put(s,X);
		list[X] = s;
		return X++;
	}
	@SuppressWarnings("unchecked")
	static ArrayList<Integer> graph[] = new ArrayList[25];
	@SuppressWarnings("unchecked")
	static ArrayList<Integer> revGraph[] = new ArrayList[25];
	static String[] list;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		map = new HashMap<String,Integer>();
		list = new String[25];
		stack = new Stack<Integer>();
		visited = new BitSet(25);
		for(int i = 0;i < 25;i++) {
			graph[i] = new ArrayList<Integer>();
			revGraph[i] = new ArrayList<Integer>();
		}
		int n,m,TC = 0;
		String uString,vString;
		boolean firstOutput = true;
		while((n = getInt()) != 0 && (m = getInt()) != 0) {
			map.clear();
			X = 0;
			visited.clear();
			for(int i = 0;i < 25;i++) {graph[i].clear(); revGraph[i].clear();}
			if(!firstOutput)	System.out.println();
			firstOutput = false;
			while(m-- > 0) {
				uString = getString(); vString = getString();
				int u = getVertex(uString),v = getVertex(vString);
				graph[u].add(v);	revGraph[v].add(u);
			}
			stack.clear();
			for(int i = 0;i < n;i++) if(!visited.get(i)) dfs(i);
			visited.clear();
			System.out.println("Calling circles for data set " + ++TC + ":");
			while(!stack.isEmpty()) {
				int u = stack.pop();
				if(!visited.get(u))
					System.out.println(dfs(u,new StringBuilder()).substring(2));
			}
		}
	}
	/*FINDING SCC*/
	static Stack<Integer> stack;
	static BitSet visited;
	static void dfs(int u) {
		visited.set(u,true);
		for(Integer v: graph[u]) if(!visited.get(v)) dfs(v);
		stack.push(u);
	}
	static String dfs(int u,StringBuilder path) {
		visited.set(u,true);
		path.append(", " + list[u]);
		for(Integer v: revGraph[u]) if(!visited.get(v)) dfs(v,path);
		return path.toString();
	}
}
