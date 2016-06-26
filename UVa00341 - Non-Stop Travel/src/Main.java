import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static final int INF = 1000000;
	static StringBuilder sb;
	static void getPath(int[][] path,int u,int v) {
		if(u == v) {
			sb.append(v);
			return;
		}
		getPath(path,u,path[u][v]);
		sb.append(" " + v);
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n,m,u,v,w,TC = 0;
		int[][] path = new int[11][11],graph = new int[11][11];
		while((n = getInt()) != 0) {
			for(int i = 0;i <= 10;i++) for(int j = 0;j <= 10;j++)
				graph[i][j] = i == j ? 0:INF;
			for(int i = 1;i <= n;i++) {
				m = getInt();
				while(m-- > 0) {
					v = getInt(); w = getInt();
					path[i][v] = i;
					graph[i][v] = w;
				}
			}
			u = getInt(); v = getInt();
			for(int k = 1;k <= n;k++) for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++)
			if(graph[i][j] > graph[i][k] + graph[k][j]) {
				path[i][j] = path[k][j];
				graph[i][j] = graph[i][k] + graph[k][j];
			}
			sb = new StringBuilder();
			getPath(path,u,v);
			System.out.printf("Case %d: Path = %s; %d second delay\n",++TC,sb.toString(),graph[u][v]);
		}
	}
}
