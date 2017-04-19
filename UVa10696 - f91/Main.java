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
		int n,dp[] = new int[1000001];
		for(int i = 101;i <= 1000000;i++)	dp[i] = i - 10;
		for(int i = 100;i > 0;i--)	dp[i] = dp[dp[i+11]];
		while((n = Integer.parseInt(in.readLine())) != 0)
			out.write("f91(" + n + ") = " + dp[n] + "\n");
		out.flush();
	}
}
