import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int p,q;
		while((p = getInt()) != -1 & (q = getInt()) != -1)
			out.write(funcS(p,q) + "\n");
		out.flush();
	}
	static long funcS(long n) {
		long ans = 0;
		while(n > 0) {
			long x = n % 10;
			ans += (x * (x + 1)) / 2;
			ans += 45 * (n /= 10);
		}
		return ans;
	}
	static long funcS(int p,int q) {
		return funcS(q) - funcS(Math.max(p-1,0));
	}
}
