import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = 0,l,s;
		for(int i = 0;i < dp.length;i++) for(int j = 0;j < dp[i].length;j++)
			Arrays.fill(dp[i][j],-1);
		while((l = getInt()) != 0 & (s = getInt()) != 0) {
			out.write("Case " + ++TC + ": ");
			if(l <= 26 && s <= 351)	out.write(run(1,l,s) + "\n");
			else	out.write("0\n");
		}
		out.flush();
	}
	static int[][][] dp = new int[28][27][352];
	static int run(int c,int l,int s) {
		if(dp[c][l][s] != -1)	return dp[c][l][s];
		if(l == 0 && s == 0)	return dp[c][l][s] = 1;
		if(l == 0 || s == 0)	return dp[c][l][s] = 0;
		dp[c][l][s] = 0;
		for(int i = c;i <= 26 && i <= s;i++)	dp[c][l][s] += run(i+1,l-1,s-i);
		return dp[c][l][s];
	}
}
