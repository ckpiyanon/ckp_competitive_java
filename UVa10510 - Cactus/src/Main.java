import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Stack;

public class Main {
	static final int MAXV = 10000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		for(int i = 0;i < MAXV;i++)	graph.add(new ArrayList<Integer>());
		int TC = getInt(),n,m;
		while(TC-- > 0) {
			n = getInt(); m = getInt();
			for(ArrayList<Integer> each:graph)	each.clear();
			while(m-- > 0)	graph.get(getInt()).add(getInt());
			Arrays.fill(num,-1); Arrays.fill(low,-1);
			sccCount = numscc = 0; isCactus = true; visited.clear(); stack.clear();
			for(int i = 0;i < n;i++) if(num[i] == -1) dfs(i);
			System.out.println((numscc == 1 && isCactus) ? "YES":"NO");
		}
	}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(MAXV);
	static Stack<Integer> stack = new Stack<Integer>();
	static BitSet visited = new BitSet(MAXV);
	static int[] num = new int[MAXV],low = new int[MAXV];
	static int sccCount,numscc;
	static boolean isCactus;
	static void dfs(int u) {
		num[u] = low[u] = sccCount++;
		visited.set(u); stack.push(u);
		for(Integer v:graph.get(u)) {
			if(num[v] > num[u])	isCactus = false; // check for forward edge
			if(num[v] == -1)	dfs(v);
			if(visited.get(v))	low[u] = Math.min(low[u],low[v]);
		}
		if(low[u] == num[u]) {
			numscc++;
			while(!stack.isEmpty()) {
				int v = stack.pop();
				visited.set(v,false);
				if(u == v)	break;
			}
		}
	}
}
