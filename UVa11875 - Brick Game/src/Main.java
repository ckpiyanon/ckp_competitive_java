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
		int TC = getInt(),x = 0,n;
		for(int tc = 1;tc <= TC;tc++) {
			n = getInt();
			for(int i = 0;i < n;i++) {
				if(i == n / 2)	x = getInt();
				else	getInt();
			}
			out.write("Case " + tc + ": " + x + "\n");
		}
		out.flush();
	}
}
