import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int a,b;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			a = (int)st.nval; st.nextToken(); b = (int)st.nval;
			out.write("[" + (a / b) + ";");
			a %= b; a ^= b; b ^= a; a ^= b;
			while(b != 0) {
				out.write("" + a / b);
				a %= b; a ^= b; b ^= a; a ^= b;
				if(b != 0)	out.write(",");
				else	out.write("]\n");
			}
		}
		out.flush();
	}
}
