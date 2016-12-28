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
		StringTokenizer st; String s;
		int TC = Integer.parseInt(in.readLine()),i,j;
		while(TC-- > 0) {
			st = new StringTokenizer(in.readLine());
			s = new BigDecimal(st.nextToken()).add(new BigDecimal(st.nextToken())).toPlainString();
			i = 0; j = s.length();
			while(s.charAt(i) == '0')	i++;
			if(s.charAt(i) == '.')		i--;
			while(s.charAt(j-1) == '0')	j--;
			if(s.charAt(j-1) == '.')	j++;
			out.write(s.substring(i,j) + "\n");
		}
		out.flush();
	}
}
