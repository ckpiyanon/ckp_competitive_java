import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
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
		num = new int[25];
		low = new int[25];
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
			visited.clear();
			Arrays.fill(num,-1);
			Arrays.fill(low,-1);
			System.out.println("Calling circles for data set " + ++TC + ":");
			scc = 1;
			for(int i = 0;i < n;i++)
				if(num[i] == -1)	dfs(i);
		}
	}
	/*FINDING SCC*/
	static Stack<Integer> stack;
	static BitSet visited;
	static int[] num,low;
	static int scc;
	static void dfs(int u) {
		low[u] = num[u] = scc++;
		visited.set(u,true);
		stack.push(u);
		for(Integer v:graph[u]) {
			if(num[v] == -1)	dfs(v);
			if(visited.get(v))	low[u] = Math.min(low[u],low[v]);
		}
		if(low[u] == num[u]) {
			while(!stack.isEmpty()) {
				int v = stack.pop();
				visited.set(v,false);
				System.out.print(list[v] + (u == v ? "\n":", "));
				if(u == v)	break;
			}
		}
	}
}
