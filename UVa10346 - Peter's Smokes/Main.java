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
		int a,b,ans;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			a = (int)st.nval; st.nextToken(); b = (int)st.nval;
			ans = a;
			while(a >= b) {
				ans += a / b;
				a = (a % b) + a / b;
			}
			out.write(ans + "\n");
		}
		out.flush();
	}
}
