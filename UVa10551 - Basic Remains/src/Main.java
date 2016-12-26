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
		String s;
		int b;
		while((s = in.readLine()) != null && !s.equals("0")) {
			st = new StringTokenizer(s);
			b = Integer.parseInt(st.nextToken());
			out.write(new BigInteger(st.nextToken(),b).mod(new BigInteger(st.nextToken(),b)).toString(b) + "\n");
		}
		out.flush();
	}
}
