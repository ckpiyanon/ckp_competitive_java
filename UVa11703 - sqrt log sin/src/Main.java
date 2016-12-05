import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MOD = 1000000;
		int n;
		int[] dp = new int[1000001];
		dp[0] = 1;
		for(int i = 1;i <= 1000000;i++)
			dp[i] = (dp[(int)(i - Math.sqrt(i))] + dp[(int)Math.log(i)] + dp[(int)(i * Math.pow(Math.sin(i),2))]) % MOD;
		while((n = Integer.parseInt(in.readLine())) != -1)	out.write(dp[n] + "\n");
		out.flush();
	}
}
