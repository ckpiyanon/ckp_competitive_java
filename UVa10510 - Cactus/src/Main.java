import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	
	static int n,m;
	
	static int rank;
	static ArrayList<ArrayList<Integer>> graph;
	static BitSet visited = new BitSet(10000);
	static int[] num = new int[10000],low = new int[10000];
	
	static boolean isSCC() {visited.clear(); return visitGraph(0) == n;}
	static int visitGraph(int u) {
		visited.set(u);
		int num = 0;
		for(Integer v:graph.get(u)) if(visited.get(v))
			num += visitGraph(v);
		return num;
	}
	
	static boolean isCactus() {rank = 0; Arrays.fill(num,-1); Arrays.fill(low,-1); return tarjan(0);}
	static boolean tarjan(int u) {
		if(num[u] > -1)	return false;
		num[u] = low[u] = rank++;
		for(Integer v: graph.get(u)) {
			if(num[v] == -1) {
				tarjan(v);
				low[u] = Math.min(low[u],low[v]);
			} else low[u] = Math.min(low[u],num[v]);
		}
		return true;
	}
	
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt();
		int[] inDeg = new int[10000],outDeg = new int[10000];
		while(TC-- > 0) {
			n = getInt(); m = getInt();
			while(graph.size() < n)	graph.add(new ArrayList<Integer>());
			for(int i = 0;i < n;i++)	graph.get(i).clear();
			while(m-- > 0) {
				outDeg[getInt()]++;
				inDeg[getInt()]++;
			}
		}
	}
}
