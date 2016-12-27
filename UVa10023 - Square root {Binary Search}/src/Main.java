import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static BigInteger TWO = BigInteger.valueOf(2);
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger n,ans;
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			in.readLine();
			ans = n = new BigInteger(in.readLine());
			while(!ans.equals(ans = ans.add(n.divide(ans)).divide(TWO)));
			out.write(ans + "\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
}
