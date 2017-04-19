import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger[] dp = new BigInteger[80];
		dp[0] = BigInteger.ONE; dp[1] = dp[0].add(BigInteger.ONE);
		int n;
		for(int i = 2;i < 80;i++)	dp[i] = dp[i-1].add(dp[i-2]);
		while((n = Integer.parseInt(in.readLine())) != 0)	out.write(dp[n-1] + "\n");
		out.flush();
	}
}
