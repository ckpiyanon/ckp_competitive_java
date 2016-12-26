import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			BigInteger p = new BigInteger(st.nextToken());
			st.nextToken();
			BigInteger q = new BigInteger(st.nextToken());
			BigInteger gcd = p.gcd(q);
			out.write(p.divide(gcd) + " / " + q.divide(gcd) + "\n");
		}
		out.flush();
	}
}
