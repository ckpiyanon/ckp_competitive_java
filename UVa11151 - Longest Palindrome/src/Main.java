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
		while(TC-- > 0) {
			s = in.readLine().toCharArray();
			for(int[] each:dp)	Arrays.fill(each,-1);
			out.write(play(0,s.length - 1) + "\n");
		}
		out.flush();
	}
	static char[] s;
	static int[][] dp = new int[1001][1001];
	static int play(int l,int r) {
		if(l > r)	return 0;
		if(l == r)	return 1;
		if(dp[l][r] != -1)	return dp[l][r];
		if(l + 1 == r)	return dp[l][r] = s[l] == s[r] ? 2:1;
		return dp[l][r] = s[l] == s[r] ? 2 + play(l+1,r-1):Math.max(play(l+1,r),play(l,r-1));
	}
}
