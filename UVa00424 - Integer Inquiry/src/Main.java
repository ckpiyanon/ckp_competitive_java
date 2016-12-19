import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger bi = BigInteger.ZERO;
		String inp;
		while((inp = in.readLine()) != null && !inp.equals("0"))
			bi = bi.add(new BigInteger(inp));
		out.write(bi.toString() + "\n");
		out.flush();
	}
}
