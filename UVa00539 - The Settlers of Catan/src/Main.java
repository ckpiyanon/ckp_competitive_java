import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int m,u,v,max;
		while((n = getInt()) != 0 & (m = getInt()) != 0) {
			Arrays.fill(graph,0);
			while(m-- > 0) {
				u = getInt(); v = getInt();
				graph[u] |= 1 << v; graph[v] |= 1 << u;
			}
			max = 0;
			for(int i = 0;i < n;i++)	max = Math.max(max,dfs(i));
			out.write(max + "\n");
		}
		out.flush();
	}
	static int n;
	static int[] graph = new int[25];
	static int dfs(int u) {
		int ans = 0;
		for(int i = 0;i < n;i++) if((graph[u] & (1 << i)) != 0) {
			graph[u] &= ~(1 << i);
			graph[i] &= ~(1 << u);
			ans = Math.max(ans,1 + dfs(i));
			graph[u] |= (1 << i);
			graph[i] |= (1 << u);
		}
		return ans;
	}
}
