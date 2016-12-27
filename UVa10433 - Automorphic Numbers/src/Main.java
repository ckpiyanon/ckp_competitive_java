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
		String ins;
		while((ins = in.readLine()) != null) {
			if(new BigInteger(ins).pow(2).toString().endsWith(ins))
				out.write("Automorphic number of " + ins.length() + "-digit.\n");
			else	out.write("Not an Automorphic number.\n");
		}
		out.flush();
	}
}
