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
		StringTokenizer st;
		BigInteger bi;
		int n,m,tc = 0;
		while(true) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0)	break;
			bi = BigInteger.ZERO;
			while(n-- > 0)	bi = bi.add(new BigInteger(in.readLine()));
			out.write("Bill #" + ++tc + " costs " + bi + ": each friend should pay " + bi.divide(BigInteger.valueOf(m)) + "\n\n");
		}
		out.flush();
	}
}
