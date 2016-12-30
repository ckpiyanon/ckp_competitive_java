import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		long dp[] = new long[51];
		dp[0] = dp[1] = 1;
		for(int i = 2;i <= 50;i++)	dp[i] = dp[i-1] + dp[i-2];
		while((n = Integer.parseInt(in.readLine())) != 0)	out.write(dp[n] + "\n");
		out.flush();
	}
}
