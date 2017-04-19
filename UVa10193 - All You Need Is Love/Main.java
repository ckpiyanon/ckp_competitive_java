import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static long gcd(long a,long b) {
		while(b > 0) {
			a %= b;
			b ^= a; a ^= b; b ^= a;
		}
		return a;
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1;tc <= TC;tc++) {
			long p1 = Integer.parseInt(in.readLine(),2),p2 = Integer.parseInt(in.readLine(),2);
			out.write("Pair #" + tc + ": " + (gcd(p1,p2) > 1 ? "All you need is love!":"Love is not all you need!") + "\n");
		}
		out.flush();
	}
}
