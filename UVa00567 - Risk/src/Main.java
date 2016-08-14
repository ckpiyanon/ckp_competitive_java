import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static final int INF = 10000;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n,u,v,X = 0;
		int graph[][] = new int[20][20];
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval;
			for(int i = 0;i < 20;i++) for(int j = 0;j < 20;j++)
				graph[i][j] = i == j ? 0:INF;
			for(u = 0;u < 19;u++) {
				while(n-- > 0) {
					v = getInt() - 1;
					graph[u][v] = graph[v][u] = 1;
				}
				if(u < 18) n = getInt();
			}
			for(int k = 0;k < 20;k++)
				for(int i = 0;i < 20;i++)
					for(int j = 0;j < 20;j++)
						graph[i][j] = Math.min(graph[i][j],graph[i][k] + graph[k][j]);
			n = getInt();
			System.out.println("Test Set #" + ++X);
			while(n-- > 0)
				System.out.printf("%2d to %2d: %d\n",u = getInt(),v = getInt(),graph[u-1][v-1]);
			System.out.println();
		}
	}
}
