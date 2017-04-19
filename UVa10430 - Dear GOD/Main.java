import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger t,tn;
		boolean first = true;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			if(first) {out.write("Dear GOD, Pardon Me"); first = false;}
			out.write("\n");
			t = BigInteger.valueOf((long)st.nval);
			st.nextToken();
			tn = t.pow((int)st.nval);
			out.write("X = " + tn.subtract(BigInteger.ONE).divide(t.subtract(BigInteger.ONE)) + "\nK = " + tn + "\n");
		}
		out.flush();
	}
}
