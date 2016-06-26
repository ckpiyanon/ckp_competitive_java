import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] s;
	static int[][] dp;
	static int calc(int l,int r) {
		if(l >= r)	return 0;
		if(dp[l][r] != -1)	return dp[l][r];
		if(s[l] == s[r])	return dp[l][r] = calc(l+1,r-1);
		return dp[l][r] = Math.min(Math.min(calc(l+1,r),calc(l,r-1)),calc(l+1,r-1)) + 1;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = 0;
		dp = new int[1001][1001];
		in.readLine();
		while(in.ready()) {
			s = in.readLine().toCharArray();
			for(int[] a:dp)	Arrays.fill(a,-1);
			System.out.println("Case " + ++TC + ": " + calc(0,s.length-1));
		}
	}
}
