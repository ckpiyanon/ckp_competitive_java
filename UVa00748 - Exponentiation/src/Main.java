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
		String s;
		while((s = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			StringBuilder sb = new StringBuilder(new BigDecimal(st.nextToken()).pow(Integer.parseInt(st.nextToken())).toPlainString());
			int start = 0,end = sb.length();
			while(sb.charAt(start) == '0')	start++;
			while(sb.charAt(end - 1) == '0')	end--;
			out.write(sb.substring(start,end) + "\n");
		}
		out.flush();
	}
}
