import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String ans;
		int TC = Integer.parseInt(in.readLine()),i;
		while(TC-- > 0) {
			st = new StringTokenizer(in.readLine());
			st = new StringTokenizer(new BigDecimal(st.nextToken()).add(new BigDecimal(st.nextToken())).toPlainString(),".");
			ans = st.nextToken(); i = 0;
			while(ans.charAt(i) == '0' && i < ans.length() - 1)	i++;
			out.write(ans.substring(i) + ".");
			ans = st.nextToken(); i = ans.length();
			while(i > 1 && ans.charAt(i-1) == '0')	i--;
			out.write(ans.substring(0,i) + "\n");
		}
		out.flush();
	}
}
