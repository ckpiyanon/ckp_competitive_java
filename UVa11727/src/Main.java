import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),a,b,c;
		for(int tc = 1;tc <= TC;tc++) {
			a = getInt(); b = getInt(); c = getInt();
			System.out.println("Case " + tc + ": " + Math.max(Math.min(a,b),Math.max(Math.min(a,c),Math.min(b,c))));
		}
	}
}
