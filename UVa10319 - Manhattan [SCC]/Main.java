import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Stack;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt();
		while(TC-- > 0) {
			int nS = getInt(),nA = getInt(),m = getInt();
			Sat sat = new Sat(nS + nA);
			while(m-- > 0) {
				int s1 = getInt(),a1 = getInt() + nS,s2 = getInt(),a2 = getInt() + nS;
				int distS = s1 - s2,distA = a1 - a2;
				if(distS == 0 && distA == 0)	continue;
				boolean dirS = distA > 0,dirA = distS > 0;
				if(distS == 0)		sat.add(s1,dirS,s1,dirS);
				else if(distA == 0)	sat.add(a1,dirA,a1,dirA);
				else {
					sat.add(s1,dirS,s2,dirS); sat.add(s1,dirS,a1,dirA);
					sat.add(a2,dirA,s2,dirS); sat.add(a2,dirA,a1,dirA);
					sat.add(s2,dirS,s1,dirS); sat.add(s2,dirS,a2,dirA);
					sat.add(a1,dirA,s1,dirS); sat.add(a1,dirA,a2,dirA);
				}
			}
			System.out.println(sat.solve() ? "Yes":"No");
		}
	}
	static class Sat {
		private ArrayList<ArrayList<Integer>> graph;
		private Stack<Integer> stack;
		private BitSet visited;
		private int[] num,low;
		private int size,numscc;
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
			for(int i = 0;i < size;i++) if(num[i] == -1) dfs(i);
			for(int i = 0;i < size;i += 2)
				if(low[i] != -1 && low[i^1] != -1 && low[i] == low[i^1])
					return false;
			return true;
		}
		private void dfs(int u) {
			low[u] = num[u] = numscc++;
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
