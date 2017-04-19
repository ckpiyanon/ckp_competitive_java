import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static double getNum() throws Exception {st.nextToken(); return st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		double[][] graph = new double[20][20];
		int[][] hops = new int[20][20];
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int)st.nval;
			for(int i = 0;i < 20;i++) {Arrays.fill(graph[i],1); Arrays.fill(hops[i],1000);}
			for(int i = 0;i < n;i++) for(int j = 0;j < n;j++) if(i != j)
				graph[i][j] = getNum();
			for(int k = 0;k < n;k++) for(int i = 0;i < n;i++) for(int j = 0;j < n;j++)
				if(graph[i][k] * graph[k][j] >= 1.0 && hops[i][k] + hops[k][j] < hops[i][j]) {
					hops[i][j] = hops[i][k] + hops[k][j];
					graph[i][j] = graph[i][k] * graph[k][j];
				}
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++)
					System.out.print(graph[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
		out.flush();
	}
}
