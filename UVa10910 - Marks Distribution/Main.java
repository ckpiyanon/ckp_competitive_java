import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt();
		int[][][] dp = new int[71][71][71];
		for(int n = 0;n <= 70;n++) for(int t = 0;t <= 70;t++) for(int p = 0;p <= 70;p++) {
			if(n == 0 && t == 0)	dp[n][t][p] = 1;
			else if(n == 0 || t == 0)	dp[n][t][p] = 0;
			else	for(int i = p;t - i >= p*(n-1);i++)	dp[n][t][p] += dp[n-1][t-i][p];
		}
		while(TC-- > 0)	out.write(dp[getInt()][getInt()][getInt()] + "\n");
		out.flush();
	}
}
