import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static final int INF = 100000000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt(),n;
		int[][] arr = new int[10][1000],dp = new int[10][1001];
		while(TC-- > 0) {
			n = getInt() / 100;
			for(int i = 9;i >= 0;i--) for(int j = 0;j < n;j++)
				arr[i][j] = getInt();
			for(int[] each:dp)	Arrays.fill(each,INF);
			dp[0][0] = 0;
			for(int j = 0;j < n;j++) for(int i = 0;i <= Math.min(n-j,9);i++) {
				if(i > 0)	dp[i-1][j+1] = Math.min(dp[i-1][j+1],dp[i][j] + 20 - arr[i][j]);
				if(i < 9)	dp[i+1][j+1] = Math.min(dp[i+1][j+1],dp[i][j] + 60 - arr[i][j]);
				dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j] + 30 - arr[i][j]);
			}
			out.write(dp[0][n] + "\n\n");
		}
		out.flush();
	}
}
