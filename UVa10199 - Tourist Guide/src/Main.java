import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n,m,u,v,TC = 0;
		while(graph.size() < 100)	graph.add(new ArrayList<Integer>());
		while((n = getInt()) != 0) {
			map.clear();
			for(int i = 0;i < n;i++)	map.put(getString(),i);
			for(Map.Entry<String,Integer> entry:map.entrySet())
				names[entry.getValue()] = entry.getKey();
			for(ArrayList<Integer> l:graph)	l.clear();
			m = getInt();
			while(m-- > 0) {
				u = map.get(getString());
				v = map.get(getString());
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			rank = 0;
			Arrays.fill(num,-1);
			ans.clear();
			for(int i = 0;i < n;i++)	parent[i] = i;
			for(int i = 0;i < n;i++)	if(num[i] == -1) {
				numChildren = 0;
				root = i;
				dfs(i);
			}
			if(TC > 0)	System.out.println();
			System.out.println("City map #" + ++TC + ": " + ans.size() + " camera(s) found");
			for(String s:ans)	System.out.println(s);
		}
	}
	static void dfs(int u) {
		num[u] = low[u] = rank++;
		for(Integer v:graph.get(u)) {
			if(num[v] == -1) {
				if(u == root)	numChildren++;
				parent[v] = u;
				dfs(v);
				low[u] = Math.min(low[u],low[v]);
				if(u != root && low[v] >= num[u])	ans.add(names[u]);
			}
			else if(parent[u] != v)	low[u] = Math.min(low[u],num[v]);
		}
		if(u == root && numChildren > 1)	ans.add(names[u]);
	}
	static int low[] = new int[100],num[] = new int[100],parent[] = new int[100],rank,numChildren,root;
	static String[] names = new String[100];
	static TreeSet<String> ans = new TreeSet<String>();
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(100);
}
