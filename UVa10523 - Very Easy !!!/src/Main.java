import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,a;
		BigInteger pow[][] = new BigInteger[151][16];
		BigInteger dp[][] = new BigInteger[151][16];
		for(a = 0;a <= 15;a++) for(n = 0;n <= 150;n++) {
			if(a == 0)	pow[n][a] = BigInteger.ZERO;
			else if(n == 0)	pow[n][a] = BigInteger.ONE;
			else	pow[n][a] = pow[n-1][a].multiply(BigInteger.valueOf(a));
		}
		for(a = 0;a <= 15;a++) for(n = 0;n <= 150;n++) {
			if(a == 0 || n == 0)	dp[n][a] = BigInteger.ZERO;
			else	dp[n][a] = pow[n][a].multiply(BigInteger.valueOf(n)).add(dp[n-1][a]);
		}
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval; st.nextToken(); a = (int)st.nval;
			out.write(dp[n][a] + "\n");
		}
		out.flush();
	}
}
