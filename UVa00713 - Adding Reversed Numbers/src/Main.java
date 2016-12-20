import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch (Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			out.write(new BigInteger(
					new StringBuilder(
							new BigInteger(new StringBuilder(st.nextToken()).reverse().toString())
								.add(new BigInteger(new StringBuilder(st.nextToken()).reverse().toString())).toString())
									.reverse().toString())
					+ "\n");
		}
		out.flush();
	}
}
