import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static final int MOD = 1000000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,m;
		int[][] dp = new int[101][101];
		for(int i = 0;i <= 100;i++) for(int j = 1;j <= 100;j++) {
			if(j == 0)	dp[i][j] = 0;
			else if(j == 1)	dp[i][j] = 1;
			else for(int k = 0;k <= i;k++)	dp[i][j] = (dp[i][j] + dp[i-k][j-1]) % MOD;
		}
		while((n = getInt()) != 0 & (m = getInt()) != 0)	out.write(dp[n][m] + "\n");
		out.flush();
	}
}
