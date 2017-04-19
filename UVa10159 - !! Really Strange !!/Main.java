import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static final BigInteger ONE = BigInteger.ONE;
	static final BigInteger TWO = BigInteger.valueOf(2);
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger n;
		String s;
		while((s = in.readLine()) != null) {
			n = new BigInteger(s);
			if(n.equals(BigInteger.ZERO))	s = "1";
			else	s = n.multiply(n.subtract(ONE)).add(TWO).toString();
			out.write(s + "\n");
		}
		out.flush();
	}
}
