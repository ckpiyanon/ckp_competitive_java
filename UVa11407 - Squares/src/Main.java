import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		int[] dp = new int[10001];
		Arrays.fill(dp,Integer.MAX_VALUE); dp[0] = 0;
		for(int i = 1;i <= 10000;i++)	for(int j = 1;j*j <= i;j++)
			dp[i] = Math.min(dp[i],1 + dp[i - j*j]);
		while(TC-- > 0)	out.write(dp[Integer.parseInt(in.readLine())] + "\n");
		out.flush();
	}
}
