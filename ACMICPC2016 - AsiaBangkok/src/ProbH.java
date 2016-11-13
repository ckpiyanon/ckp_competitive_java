import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class ProbH {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("inH.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt();
		while(TC-- > 0) {
			K = getInt(); M = getInt(); N = getInt();
			for(int i = 0;i < N;i++)	sP[i] = getInt();
			for(int i = 0;i < N;i++)	rP[i] = getInt();
			for(int[][] eachL:dp) for(int[] eachR:eachL) Arrays.fill(eachR,-1);
			out.write(play(0,100,0) + "\n");
		}
		out.flush(); out.close();
	}
	static int N,K,M;
	static int[] sP = new int[8],rP = new int[8];
	static int[][][] dp = new int[256][101][101];
	static int play(int select,int rStr,int rTox) {
		if(dp[select][rStr][rTox] != -1)	return dp[select][rStr][rTox];
		int ans = 0;
		if(rStr > K) {
			ans = Math.max(ans,1 + play(select,rStr - K,Math.max(rTox - M,0)));
			for(int i = 0;i < N;i++) if((select >> i) % 2 == 0) {
				int newT = Math.max(rTox - M,0) + rP[i];
				if(newT >= 100)	continue;
				ans = Math.max(ans,1 + play(select | (1 << i),Math.min(rStr - K + sP[i],100),newT));
			}
		}
		return dp[select][rStr][rTox] = ans;
	}
}
