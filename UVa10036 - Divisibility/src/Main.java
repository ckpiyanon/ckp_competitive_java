import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt();
		while(TC-- > 0) {
			n = getInt(); k = getInt();
			for(int i = 0;i < n;i++)	arr[i] = getInt();
			for(int[] each:dp)	Arrays.fill(each,-1);
			out.write(run(0,0) == 1 ? "Divisible\n":"Not divisible\n");
		}
		out.flush();
	}
	static int run(int sum,int idx) {
		sum = ((sum % k) + k) % k;
		if(idx == n)	return sum == 0 ? 1:0;
		if(dp[sum][idx] != -1)	return dp[sum][idx];
		return dp[sum][idx] = run(sum + arr[idx],idx + 1) | run(sum - arr[idx],idx + 1);
	}
	static int n,k;
	static int[] arr = new int[10000];
	static int[][] dp = new int[100][10000];
}
