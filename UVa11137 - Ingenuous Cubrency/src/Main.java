import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long dp[];
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		dp = new long[10000];
		dp[0] = 1;
		for(int i = 1;i <= 21;i++)
			for(int j = 0;j + i*i*i < 10000;j++)
				dp[j + i*i*i] += dp[j];
		while(in.ready())	System.out.println(dp[Integer.parseInt(in.readLine().trim())]);
	}
}
