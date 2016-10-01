import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
	static int task(char ch) {return ch - 'A' + 12;}
	static int comp(int n) {return n + 2;}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String ins,s1,s2;
		int numTask,n,t;
		while(true) {
			numTask = 0;
			for(int[] each:graph)	Arrays.fill(each,0);
			for(int i = comp(0);i < comp(10);i++)	graph[i][1] = 1;
//			for(int i = task('A');i <= task('Z');i++)	graph[0][i] = 1;
			while((ins = in.readLine()) != null && ins.length() > 0) {
				st = new StringTokenizer(ins);
				s1 = st.nextToken(); s2 = st.nextToken();
				t = task(s1.charAt(0));	numTask += n = s1.charAt(1) - '0';
				graph[0][t] += n;
				for(int i = 0;i < s2.length() - 1;i++) {
					graph[t][comp(s2.charAt(i) - '0')] = 1;
				}
			}
			if(maxflow(0,1) < numTask)	System.out.println("!");
			else {
				for(int i = comp(0);i < comp(10);i++)
					System.out.print(getTask(i));
				System.out.println();
			}
			if(ins == null)	break;
		}
	}
	static char getTask(int comp) {
		for(char i = 'A';i <= 'Z';i++) {
			if(graph[comp][task(i)] > 0)	return i;
		}
		return '_';
	}
	
	static int graph[][] = new int[38][38];
	static BitSet visited = new BitSet(38);
	static int maxflow(int s,int t) {
		int f,ans = 0;
		visited.clear();
		while((f = dfs(s,t,Integer.MAX_VALUE)) != 0) {
			ans += f;
			visited.clear();
		}
		return ans;
	}
	static int dfs(int s,int t,int flow) {
		visited.set(s);
		if(s == t)	return flow;
		int f;
		for(int i = 0;i < 38;i++) if(!visited.get(i) && graph[s][i] > 0 && (f = dfs(i,s,Math.min(flow,graph[s][i]))) != 0) {
			graph[s][i] -= f;	graph[i][s] += f;
			return f;
		}
		return 0;
	}
}
