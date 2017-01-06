import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int a,b,x,TC = 0;
		while((a = getInt()) != 0 && (b = getInt()) != 0) {
			x = (int)Math.ceil((double)a / (double)b) - 1;
			out.write("Case " + ++TC + ": " + (x <= 26 ? x + "\n":"impossible\n"));
		}
		out.flush();
	}
}
