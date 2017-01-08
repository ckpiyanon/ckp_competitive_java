import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine()),n;
		boolean printed;
		for(int tc = 1;tc <= TC;tc++) {
			out.write("Case #" + tc + ": " + (n = Integer.parseInt(in.readLine())));
			printed = false;
			for(int i = 2;i < n;i++) if(n % i == 0) {
				out.write(" = " + i + " * " + (n / i));
				if(printed)	break;
				printed = true;
			}
			out.write("\n");
		}
		out.flush();
	}
}
