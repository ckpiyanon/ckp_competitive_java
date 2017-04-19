import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		StringTokenizer st;
		String delim = " .,/-_\\\"\'!#()[]{}?;:";
		String s;
		int TC = 0;
		int[][] dp = new int[1001][1001];
		while((s = in.readLine()) != null) {
			st = new StringTokenizer(s,delim);
			list1.clear(); list2.clear();
			while(st.hasMoreTokens())	list1.add(st.nextToken());
			st = new StringTokenizer(in.readLine(),delim);
			while(st.hasMoreTokens())	list2.add(st.nextToken());
			for(int i = 1;i <= list1.size();i++) for(int j = 1;j <= list2.size();j++) {
				if(list1.get(i-1).equals(list2.get(j-1)))	dp[i][j] = dp[i-1][j-1] + 1;
				else	dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
			}
			out.write((++TC < 10 ? " ":"") + TC + ". ");
			if(list1.size() == 0 || list2.size() == 0)
				out.write("Blank!\n");
			else
				out.write("Length of longest match: " + dp[list1.size()][list2.size()] + "\n");
		}
		out.flush();
	}
}
