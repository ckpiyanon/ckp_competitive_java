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
		int TC = getInt(),n,m,cnt;
		while(TC-- > 0) {
			n = getInt(); m = getInt(); cnt = 0;
			while(n >= m) {cnt += n / m; n = (n / m) + (n % m);}
			out.write(n == 1 ? cnt + "\n":"cannot do this\n");
		}
		out.flush();
	}
}
