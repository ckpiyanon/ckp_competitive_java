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
		int TC = getInt(),ans;
		while(TC-- > 0) {
			m = getInt(); c = getInt();
			for(int i = 0;i < c;i++) {
				k[i] = getInt();
				for(int j = 0;j < k[i];j++)	arr[i][j] = getInt();
			}
			for(int[] each:dp)	Arrays.fill(each,-1);
			ans = run(0,0);
			out.write((ans >= 0 ? ans:"no solution") + "\n");
		}
		out.flush();
	}
	static int m,c,k[] = new int[20],arr[][] = new int[20][20];
	static int dp[][] = new int[20][201];
	static int run(int idx,int sum) {
		if(idx == c)	return sum;
		if(dp[idx][sum] != -1)	return dp[idx][sum];
		int ans = -1;
		for(int i = 0;i < k[idx];i++) if(sum + arr[idx][i] <= m)
			ans = Math.max(ans,run(idx+1,sum + arr[idx][i]));
		return dp[idx][sum] = ans;
	}
}
