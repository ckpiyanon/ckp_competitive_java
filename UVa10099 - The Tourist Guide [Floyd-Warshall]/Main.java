import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int[][] graph = new int[100][100];
		int n,r,u,v,TC = 0;
		while((n = getInt()) != 0 & (r = getInt()) != 0) {
			for(int[] each:graph)	Arrays.fill(each,-1);
			while(r-- > 0)
				graph[u = getInt() - 1][v = getInt() - 1] = graph[v][u] = getInt() - 1;
			for(int k = 0;k < n;k++)
				for(int i = 0;i < n;i++)
					if(graph[i][k] != -1)
						for(int j = 0;j < n;j++)
							if(graph[j][k] != -1)
								graph[i][j] = Math.max(graph[i][j],Math.min(graph[i][k],graph[j][k]));
			u = getInt() - 1; v = getInt() - 1; r = getInt();
			System.out.print("Scenario #" + ++TC + "\nMinimum Number of Trips = ");
			System.out.println((int)Math.ceil((double)(r) / graph[u][v]));
			System.out.println();
		}
	}
}
