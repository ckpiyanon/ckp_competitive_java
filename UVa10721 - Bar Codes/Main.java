import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static final int N = 50;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long[][][] dp = new long[51][51][51];
		for(int n = 0;n <= N;n++) for(int k = 0;k <= N;k++) for(int m = 0;m <= N;m++) {
			if(n == 0 && k == 0)	dp[n][k][m] = 1;
			else if(n == 0 || k == 0)	dp[n][k][m] = 0;
			else {
				dp[n][k][m] = 0;
				for(int i = 1;i <= m && i <= n;i++)	dp[n][k][m] += dp[n-i][k-1][m];
			}
		}
		while(st.nextToken() != StreamTokenizer.TT_EOF)
			out.write(dp[(int)st.nval][getInt()][getInt()] + "\n");
		out.flush();
	}
}
