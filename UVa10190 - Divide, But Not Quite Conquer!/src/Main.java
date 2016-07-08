import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static String cal(int n,int m) {
		if(m < 2 || n < 2)	return "Boring!\n";
		StringBuilder sb = new StringBuilder(String.valueOf(n));
		while(n > 1) {
			if(n == 1)	break;
			if(n % m != 0)	return "Boring!\n";
			sb.append(' ').append(n /= m);
		}
		return sb.append('\n').toString();
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF)
			out.write(cal((int)st.nval,getInt()));
		out.flush();
	}
}
