import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Stack;

public class ProbG {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("inG.txt"));} catch(Exception e) {}
		try {System.setOut(new PrintStream(new FileOutputStream("outG.txt")));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		for(int i = 0;i < 1000;i++)	graph.add(new ArrayList<Integer>());
		int TC = getInt(),n,x,y,a,b,dA,dB;
		boolean yes;
		while(TC-- > 0) {
			for(ArrayList<Integer> each:graph)	each.clear();
			x = getInt(); y = getInt(); n = y*2;
			while(x-- > 0) {
				a = getInt(); b = getInt();
				dA = a > 0 ? 1:0; dB = b > 0 ? 1:0;
				a = Math.abs(a) - 1; b = Math.abs(b) - 1;
				graph.get(a*2 + (dA^1)).add(b*2 + dB);
				graph.get(b*2 + (dB^1)).add(a*2 + dA);
			}
//			uf = new UnionFind(n);
			Arrays.fill(roots,-1);
			stack.clear();
			visited.clear();
			Arrays.fill(num,-1);
			Arrays.fill(low,-1);
			scc = 1;
			for(int i = 0;i < n;i++)
				if(num[i] == -1)
					dfs(i);
			yes = true;
			for(int i = 0;i < n && yes;i += 2)
				if(/*roots[i] != -1 && roots[i^1] != -1 &&*/ roots[i] == roots[i^1])
					yes = false;
			System.out.println(yes ? "yes":"no");
		}
	}
	static int[] num = new int[1000],low = new int[1000],roots = new int[1000];
	static Stack<Integer> stack = new Stack<Integer>();
	static BitSet visited = new BitSet(1000);
	static int scc;
	static void dfs(int u) {
		low[u] = num[u] = scc++;
		visited.set(u);
		stack.push(u);
		for(Integer v:graph.get(u)) {
			if(num[v] == -1)	dfs(v);
			if(visited.get(v))	low[u] = Math.min(low[u],low[v]);
		}
		if(low[u] == num[u]) {
			while(!stack.isEmpty()) {
				int v = stack.pop();
				roots[v] = u;
//				uf.merge(u,v);
				visited.set(v,false);
				if(u == v)	break;
			}
		}
	}
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(1000);
}
