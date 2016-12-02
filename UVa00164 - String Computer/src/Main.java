import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter out;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str,arr[];
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		while((str = in.readLine()) != null && !str.equals("#")) {
			arr = str.split(" ");
			s1 = arr[0].toCharArray();
			s2 = arr[1].toCharArray();
			for(int i = 0;i <= s1.length;i++)	dp[i][0] = i;
			for(int i = 0;i <= s2.length;i++)	dp[0][i] = i;
			for(int i = 1;i <= s1.length;i++) for(int j = 1;j <= s2.length;j++)
				dp[i][j] =  s1[i-1] == s2[j-1] ? dp[i-1][j-1]:1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
			run(s1.length,s2.length);
			out.write("E\n");
		}
		out.flush();
	}
	static char[] s1,s2;
	static int[][] dp = new int[21][21];
	static String format(int n) {return (n < 10 ? "0":"") + n;}
	static void run(int i,int j) throws Exception {
		if(dp[i][j] == 0)	return;
		if(i == 0) {run(i,j-1); out.write("I" + s2[j-1] + format(j));}
		else if(j == 0) {run(i-1,j); out.write("D" + s1[i-1] + format(j+1));}
		else {
			int ans = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
			if(ans == dp[i][j])	run(i-1,j-1);
			else if(ans == dp[i-1][j-1]) {run(i-1,j-1); out.write("C" + s2[j-1] + format(j));}
			else if(ans == dp[i-1][j]) {run(i-1,j); out.write("D" + s1[i-1] + format(j+1));}
			else if(ans == dp[i][j-1]) {run(i,j-1); out.write("I" + s2[j-1] + format(j));}
		}
	}
}
