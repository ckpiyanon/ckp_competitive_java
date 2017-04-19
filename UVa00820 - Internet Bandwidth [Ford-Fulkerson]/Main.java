import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.BitSet;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int s,t,c,u,v,w,TC = 0;
		while((n = getInt()) != 0) {
			for(int[] each:graph)	Arrays.fill(each,0);
			s = getInt() - 1; t = getInt() - 1; c = getInt();
			while(c-- > 0) {
				graph[u = getInt() - 1][v = getInt() - 1] += w = getInt();
				graph[v][u] += w;
			}
			System.out.println("Network " + ++TC);
			System.out.println("The bandwidth is " + maxflow(s,t) + ".\n");
		}
	}
	static int n;
	static int[][] graph = new int[100][100];
	static BitSet visited = new BitSet(100);
	static int maxflow(int s,int t) {
		int f,ans = 0;
		visited.clear();
		while((f = dfs(s,t,Integer.MAX_VALUE)) > 0) {
			ans += f;
			visited.clear();
		}
		return ans;
	}
	static int dfs(int s,int t,int flow) {
		visited.set(s);
		if(s == t)	return flow;
		int f;
		for(int i = 0;i < n;i++)	if(!visited.get(i) && graph[s][i] > 0 && (f = dfs(i,t,Math.min(flow,graph[s][i]))) > 0) {
			graph[s][i] -= f;
			graph[i][s] += f;
			return f;
		}
		return 0;
	}
}
