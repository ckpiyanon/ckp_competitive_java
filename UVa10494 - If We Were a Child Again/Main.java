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
		String s;
		while((s = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			BigInteger a = new BigInteger(st.nextToken());
			char ch = st.nextToken().charAt(0);
			BigInteger b = new BigInteger(st.nextToken());
			out.write((ch == '/' ? a.divide(b):a.mod(b)) + "\n");
		}
		out.flush();
	}
}
