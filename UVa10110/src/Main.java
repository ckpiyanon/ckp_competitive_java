import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n;
		double sq;
		while(in.ready()) {
			n = Long.parseLong(in.readLine());
			if(n == 0)	break;
			sq = Math.sqrt(n);
			System.out.println(Math.abs(sq - (int)sq) < 1E-5 ? "yes":"no");
		}
		in.close();
	}
}
