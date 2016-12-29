import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int TC = Integer.parseInt(in.readLine()),sum;
		while(TC-- > 0) {
			list.clear(); sum = 0;
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
				sum += list.get(list.size() - 1);
			}
			out.write(sum % 2 == 0 && run(sum / 2,list.size()) == sum / 2 ? "YES\n":"NO\n");
		}
		out.flush();
	}
	static ArrayList<Integer> list = new ArrayList<Integer>(20);
	static int[][] dp = new int[201][21];
	static int run(int r,int idx) {
		if(idx == list.size())	for(int[] each:dp)	Arrays.fill(each,-1);
		if(idx == 0 || r == 0)	return 0;
		if(dp[r][idx] != -1)	return dp[r][idx];
		if(r < list.get(idx - 1))	return dp[r][idx] = run(r,idx - 1);
		return dp[r][idx] = Math.max(run(r,idx - 1),list.get(idx - 1) + run(r - list.get(idx - 1),idx - 1));
	}
}
