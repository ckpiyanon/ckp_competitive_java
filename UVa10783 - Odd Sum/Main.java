import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine()),a,b;
		for(int tc = 1;tc <= TC;tc++) {
			a = Integer.parseInt(in.readLine());
			b = Integer.parseInt(in.readLine());
			if(a % 2 == 0)	a++;
			if(b % 2 == 0)	b--;
			out.write("Case " + tc + ": " + (((a + b) * ((b - a) / 2 + 1)) / 2) + "\n");
		}
		out.flush();
	}
}
