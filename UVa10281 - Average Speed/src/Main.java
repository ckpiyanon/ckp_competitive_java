import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		DecimalFormat df = new DecimalFormat("0.00");
		StringTokenizer st;
		String s;
		int startTime = 0,speed = 0;
		double elapsed = 0.0;
		while(in.ready()) {
			st = new StringTokenizer(s = in.readLine(),": ");
			if(st.countTokens() == 4) {
				int t = time(st);
				elapsed += speed * (t - startTime) / 3600.0;
				startTime = t;
				speed = Integer.parseInt(st.nextToken());
			}
			else	out.write(s + " " + df.format(elapsed + speed * (time(st) - startTime) / 3600.0) + " km\n");
		}
		out.flush();
	}
	static int time(StringTokenizer st) {
		return 3600 * Integer.parseInt(st.nextToken()) + 60 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
	}
}
