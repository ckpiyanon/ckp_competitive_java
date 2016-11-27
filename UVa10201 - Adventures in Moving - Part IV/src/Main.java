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
		String str;
		int TC = Integer.parseInt(in.readLine());
		in.readLine();
		while(TC-- > 0) {
			distance = Integer.parseInt(in.readLine());
			dist.clear(); price.clear();
			while((str = in.readLine()) != null && str.length() > 0) {
				st = new StringTokenizer(str);
				dist.add(Integer.parseInt(st.nextToken()));
				price.add(Integer.parseInt(st.nextToken()));
			}
			for(int[] each:dp)	Arrays.fill(each,-1);
			out.write(play(0,100) == Integer.MAX_VALUE ? "Impossible\n":play(0,100) + "\n");
		}
		out.flush();
	}
	static int distance;
	static int[][] dp = new int[100][201];
	static ArrayList<Integer> dist = new ArrayList<Integer>(100);
	static ArrayList<Integer> price = new ArrayList<Integer>(100);
	static int play(int n,int rem) {
		if(n == dist.size())	return rem - (distance - dist.get(n-1)) < 100 ? Integer.MAX_VALUE:0;
		rem -= dist.get(n);
		if(rem <= 0)	return Integer.MAX_VALUE;
		if(dp[n][rem] != -1)	return dp[n][rem];
		int ans = Integer.MAX_VALUE;
		for(int fill = 0;fill <= 200 - rem;fill++)
			ans = Math.min(ans,price.get(n) * fill + play(n+1,rem+fill));
		return dp[n][rem] = ans;
	}
}
