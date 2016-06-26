import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static final int INF = 10000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n,g,u,v,w;
		int[][][] graph = new int[2][26][26];
		boolean b;
		while((n = getInt()) != 0) {
			for(int i = 0;i < 26;i++) {
				Arrays.fill(graph[0][i],INF);
				Arrays.fill(graph[1][i],INF);
			}
			while(n-- > 0) {
				g = getString().charAt(0) == 'Y' ? 0:1;
				b = getString().charAt(0) == 'B';
				u = getString().charAt(0) - 'A';
				v = getString().charAt(0) - 'A';
				w = getInt();
				graph[g][u][v] = w;
				if(b)	graph[g][v][u] = w;
			}
			for(int i = 0;i < 26;i++)	graph[0][i][i] = graph[1][i][i] = 0;
			for(int k = 0;k < 26;k++) for(int i = 0;i < 26;i++) for(int j = 0;j < 26;j++) {
				graph[0][i][j] = Math.min(graph[0][i][j],graph[0][i][k] + graph[0][k][j]);
				graph[1][i][j] = Math.min(graph[1][i][j],graph[1][i][k] + graph[1][k][j]);
			}
			u = getString().charAt(0) - 'A';
			v = getString().charAt(0) - 'A';
			w = INF;
			for(int i = 0;i < 26;i++)	w = Math.min(w,graph[0][u][i] + graph[1][v][i]);
			if(w == INF)	System.out.println("You will never meet.");
			else {
				System.out.print(w);
				for(int i = 0;i < 26;i++) if(graph[0][u][i] + graph[1][v][i] == w)
					System.out.print(" " + (char)(i + 'A'));
				System.out.println();
			}
		}
	}
}
