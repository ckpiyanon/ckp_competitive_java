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
		while((s = in.readLine()) != null && !s.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			String d = st.nextToken();
			s = "0" + st.nextToken().replace(d,"");
			out.write(new BigInteger(s) + "\n");
		}
		out.flush();
	}
}
