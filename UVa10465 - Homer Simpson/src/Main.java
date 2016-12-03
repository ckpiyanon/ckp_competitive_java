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
		int m,n,t,dp[] = new int[20001];
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			m = (int)st.nval; n = getInt(); t = getInt();
			dp[0] = 0;
			for(int i = 1;i <= t;i++) {
				if(i < n && i < m)	dp[i] = -1;
				else {
					int b1 = -1,b2 = -1;
					if(i >= n)	b1 = dp[i-n] != -1 ? 1 + dp[i-n]:-1;
					if(i >= m)	b2 = dp[i-m] != -1 ? 1 + dp[i-m]:-1;
					dp[i] = Math.max(b1,b2);
				}
			}
			if(dp[t] != -1)	out.write(dp[t] + "\n");
			else {
				int i = t; while(dp[--i] == -1);
				out.write(dp[i] + " " + (t - i) + "\n");
			}
		}
		out.flush();
	}
}
