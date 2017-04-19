import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		char[] sa;
		long a,b;
		int num0;
		while((s = in.readLine()) != null) {
			sa = s.toCharArray(); Arrays.sort(sa); a = b = num0 = 0;
			for(int i = s.length() - 1;i >= 0;i--) {
				b = b*10 + sa[i] - '0';
				if(sa[i] == '0')	num0++;
			}
			int i = 0;
			while(sa[i] == '0')	i++;
			a = sa[i++] - '0';
			while(num0-- > 0)	a *= 10;
			while(i < s.length())	a = a*10 + sa[i++] - '0';
			out.write(b + " - " + a + " = " + (b - a) + " = 9 * " + ((b - a) / 9) + "\n");
		}
		out.flush();
	}
}
