import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BigInteger MAX = BigInteger.valueOf(Integer.MAX_VALUE);
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String ins;
		while((ins = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(ins);
			BigInteger b1 = new BigInteger(st.nextToken());
			char opr = st.nextToken().charAt(0);
			BigInteger b2 = new BigInteger(st.nextToken());
			out.write(ins + "\n");
			if(b1.compareTo(MAX) > 0)	out.write("first number too big\n");
			if(b2.compareTo(MAX) > 0)	out.write("second number too big\n");
			if(0 < (opr == '+' ? b1.add(b2):b1.multiply(b2)).compareTo(MAX))	out.write("result too big\n");
		}
		out.flush();
	}
}
