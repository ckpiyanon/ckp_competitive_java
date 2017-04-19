import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader in; static BufferedWriter out;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		while(in.ready()) {
			str = in.readLine().toCharArray();
			for(int[] each:dp)	Arrays.fill(each,-1);
			out.write(run(0,str.length - 1) + " ");
			trace(0,str.length - 1);
			out.write("\n");
		}
		out.flush();
	}
	static char[] str;
	static int[][] dp = new int[1000][1000];
	static int run(int l,int r) {
		if(l >= r) return 0;
		if(dp[l][r] != -1)	return dp[l][r];
		return dp[l][r] = str[l] == str[r] ? run(l+1,r-1):1 + Math.min(run(l+1,r),run(l,r-1));
	}
	static void trace(int l,int r) throws Exception {
		if(l > r)	return;
		if(l == r)	out.write(str[l]);
		else if(str[l] == str[r]) {out.write(str[l]); trace(l+1,r-1); out.write(str[r]);}
		else if(dp[l+1][r] <= dp[l][r-1]) {out.write(str[l]); trace(l+1,r); out.write(str[l]);}
		else {out.write(str[r]); trace(l,r-1); out.write(str[r]);}
	}
}
