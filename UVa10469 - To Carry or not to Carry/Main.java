import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long a,b;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			a = (long)st.nval; st.nextToken(); b = (long)st.nval;
			out.write((a ^ b) + "\n");
		}
		out.flush();
	}
}
