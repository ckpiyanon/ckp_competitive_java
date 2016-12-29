import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		DecimalFormat format = new DecimalFormat("0.00");
		final double PI = Math.acos(-1);
		int TC = Integer.parseInt(in.readLine());
		double l,w,r,a;
		while(TC-- > 0) {
			l = Double.parseDouble(in.readLine());
			w = l * 6 / 10;
			r = l * 2 / 10;
			a = r*r*PI;
			out.write(format.format(a) + " " + format.format(w * l - a) + "\n");
		}
		out.flush();
	}
}
