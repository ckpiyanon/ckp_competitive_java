import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N,set,u,v;
		boolean[][] graph = new boolean[15][15];
		while((N = getInt()) != 0) {
			for(int i = 0;i < 15;i++)	Arrays.fill(graph[i],false);
			while(true) {
				u = getInt(); v = getInt();
				if(u == -1 && v == -1)	break;
				graph[u-1][v-1] = graph[v-1][u-1] = true;
			}
			for(int i = 0;i < N;i++) {
				for(int j = 0;j < N;j++) {
					System.out.print((graph[i][j] ? 1:0) + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
