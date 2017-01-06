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
		int a,b,ans,idx;
		while((a = getInt()) != 0 & (b = getInt()) != 0) {
			ans = idx = 0;
			if(a > b) {a ^= b; b ^= a; a ^= b;}
			for(int i = a;i <= b;i++) {
				int x = i == 1 ? 3:run(i);
				if(x > ans) {ans = x; idx = i;}
			}
			out.write("Between " + a + " and " + b + ", " + idx + " generates the longest sequence of " + ans + " values.\n");
		}
		out.flush();
	}
	static int run(long x) {
		if(x == 1)	return 3;
		int ret = 0;
		while(x != 1) {
			ret++;
			x = x % 2 != 0 ? 3 * x + 1:x / 2;
		}
		return ret;
	}
}
