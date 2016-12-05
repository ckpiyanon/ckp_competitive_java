import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static final int MV = 32000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt();
		while(TC-- > 0) {
			n = getInt();
			for(int i = 0;i < n;i++)	arr[i] = getInt();
			tar = getInt();
			for(int i = 0;i < n;i++)	Arrays.fill(dp[i],-1);
			if(run(1,arr[0]) == 1) {
				out.write(String.valueOf(arr[0]));
				for(int i = 1;i < n;i++)	out.write(ans[i] + String.valueOf(arr[i]));
				out.write("=" + tar + "\n");
			}
			else	out.write("NO EXPRESSION\n");
		}
		out.flush();
	}
	static int n,tar;
	static int[] arr = new int[101];
	static char[] ans = new char[101];
	static int[][] dp = new int[101][64001];
	static int run(int idx,int prod) {
		if(idx == n)	return prod == tar ? 1:0;
		int tp = prod + MV;
		if(dp[idx][tp] != -1)	return dp[idx][tp];
		if(prod % arr[idx] == 0 && run(idx + 1,prod / arr[idx]) == 1) {ans[idx] = '/'; return dp[idx][tp] = 1;}
		if(prod - arr[idx] + MV >= 0 && run(idx + 1,prod - arr[idx]) == 1) {ans[idx] = '-'; return dp[idx][tp] = 1;}
		if(prod + arr[idx] + MV <= 64000 && run(idx + 1,prod + arr[idx]) == 1) {ans[idx] = '+'; return dp[idx][tp] = 1;}
		if(prod * arr[idx] + MV <= 64000 && prod * arr[idx] + MV >= 0 && run(idx + 1,prod * arr[idx]) == 1) {ans[idx] = '*'; return dp[idx][tp] = 1;}
		return dp[idx][tp] = 0;
	}
}
