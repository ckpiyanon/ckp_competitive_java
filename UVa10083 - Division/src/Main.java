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
		BigInteger bi;
		String s;
		int t,a,b;
		while((s = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			out.write("(" + t + "^" + a + "-1)/(" + t + "^" + b + "-1) ");
			if(Math.log10(t) * (a - b) > 99 || t == 1 || a % b != 0)
				out.write("is not an integer with less than 100 digits.\n");
			else if(a == b)
				out.write("1\n");
			else {
				bi = BigInteger.valueOf(t);
				out.write(bi.pow(a).subtract(BigInteger.ONE).divide(bi.pow(b).subtract(BigInteger.ONE)) + "\n");
			}
		}
		out.flush();
	}
}
