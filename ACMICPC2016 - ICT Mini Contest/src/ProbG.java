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
		int TC = getInt(),n;
		while(TC-- > 0) {
			n = getInt();
			Sat sat = new Sat(getInt());
			while(n-- > 0)	sat.add(getInt(),getInt());
			System.out.println(sat.solve() ? "yes":"no");
		}
	}
	static class Sat {
		private ArrayList<ArrayList<Integer>> graph;
		private Stack<Integer> stack;
		private BitSet visited;
		private int[] num,low;
		private int size,sccCount;

		public Sat(int sz) {
			size = sz * 2;
			graph = new ArrayList<ArrayList<Integer>>(size);
			for(int i = 0;i < size;i++)
				graph.add(new ArrayList<Integer>());
		}
		public void add(int a,boolean ba,int b,boolean bb) {
			a--; b--;
			graph.get((a*2) ^ btoi(ba^true)).add((b*2) ^ btoi(bb));
			graph.get((b*2) ^ btoi(bb^true)).add((a*2) ^ btoi(ba));
		}
		public void add(int a,int b) {add(Math.abs(a),a > 0,Math.abs(b),b > 0);}
		private int btoi(boolean b) {return b ? 1:0;}

		public boolean solve() {
			stack = new Stack<Integer>(); visited = new BitSet(size);
			num = new int[size]; low = new int[size];
			Arrays.fill(num,-1); Arrays.fill(low,-1);
			for(int i = 0;i < size;i++) if(num[i] == -1)
				dfs(i);
			for(int i = 0;i < size;i += 2)
				if(low[i] != -1 && low[i^1] != -1 && low[i] == low[i^1])
					return false;
			return true;
		}
		private void dfs(int u) {
			low[u] = num[u] = sccCount++;
			visited.set(u); stack.push(u);
			for(Integer v:graph.get(u)) {
				if(num[v] == -1)	dfs(v);
				if(visited.get(v))	low[u] = Math.min(low[u],low[v]);
			}
			if(low[u] == num[u]) {
				while(!stack.isEmpty()) {
					int v = stack.pop();
					visited.set(v,false);
					if(u == v)	break;
				}
			}
		}
	}
}
