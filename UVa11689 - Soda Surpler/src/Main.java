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
		int TC = getInt(),rem,tol,n;
		while(TC-- > 0) {
			rem = getInt() + getInt();
			n = getInt();
			tol = 0;
			while(rem >= n) {tol += rem / n; rem = (rem / n) + (rem % n);}
			out.write(tol + "\n");
		}
		out.flush();
	}
}
