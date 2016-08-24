import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Stack;

public class Main2 {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n,m;
		graph = new ArrayList<ArrayList<Integer>>(2000);
		num = new int[2000];
		low = new int[2000];
		for(int i = 0;i < 2000;i++)	graph.add(new ArrayList<Integer>());
		while((n = getInt()) != 0 & (m = getInt()) != 0) {
			for(int i = 0;i < n;i++)	graph.get(i).clear();
			while(m-- > 0) {
				int u = getInt() - 1,v = getInt() - 1,w = getInt();
				graph.get(u).add(v);
				if(w == 2)	graph.get(v).add(u);
			}
			sccCount = numSCC = 0;
			Arrays.fill(num,-1); Arrays.fill(low,-1);
			for(int i = 0;i < n;i++) {
				if(num[i] == -1) {
					dfs(i);
				}
			}
			System.out.println(numSCC > 1 ? "0":"1");
		}
	}
	static ArrayList<ArrayList<Integer>> graph;
	static int sccCount,numSCC;
	static int[] num,low;
	static Stack<Integer> stack;
	static void dfs(int u) {
		num[u] = low[u] = ++sccCount;
		for(Integer v:graph.get(u)) {
			if(num[v] == -1) {
				dfs(v);
				low[u] = Math.min(low[u],num[v]);
			}
			if(visited.get(v))	low[u] = Math.min(low[u],low[v]);
		}
		if(num[u] == low[u]) {
			while(!stack.isEmpty()) {
				int v = stack.pop();
				visited.set(v,false);
				if(v == u)	break;
			}
			numSCC++;
		}
	}
}
