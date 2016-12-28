import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigDecimal n; String s;
		int TC = Integer.parseInt(in.readLine()),l;
		while(TC-- > 0) {
			n = BigDecimal.valueOf(0);
			while(!(s = in.readLine()).equals("0"))	n = n.add(new BigDecimal(s));
			s = n.toPlainString();
			l = s.length();
			while(s.charAt(l-1) == '0')	l--;
			if(s.charAt(l-1) == '.')	l--;
			out.write(s.substring(0,l) + "\n");
		}
		out.flush();
	}
}
