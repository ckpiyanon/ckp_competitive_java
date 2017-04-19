import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[][] dp;
	static char[] s;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			s = in.readLine().toCharArray();
			dp = new long[s.length][s.length];
			for(long[] arr:dp)	Arrays.fill(arr,-1);
			out.write(String.valueOf(play(0,s.length - 1) - 1 + "\n").getBytes());
		}
		out.flush();
	}
	static long play(int a,int b) {
		if(a > b)	return 1;
		if(dp[a][b] >= 0)	return dp[a][b];
		return dp[a][b] = play(a+1,b) + play(a,b-1) - (s[a] == s[b] ? 0:play(a+1,b-1));
	}
}