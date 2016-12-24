import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		double n = getInt(),m = getInt(),a = getInt();
		long w = (long)Math.ceil(m / a),h = (long)Math.ceil(n / a);
		System.out.println(w * h);
	}
}
