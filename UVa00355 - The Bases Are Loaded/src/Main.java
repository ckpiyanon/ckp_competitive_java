import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s;
		int r1,r2;
		while(in.ready()) {
			st = new StringTokenizer(in.readLine());
			r1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			s = st.nextToken();
			try {
				out.write(s + " base " + r1 + " = " + Long.toString(Long.parseLong(s,r1),r2).toUpperCase() + " base " + r2 + "\n");
			} catch(NumberFormatException e) {
				out.write(s + " is an illegal base " + r1 + " number\n");
			}
		}
		out.flush();
	}
}
