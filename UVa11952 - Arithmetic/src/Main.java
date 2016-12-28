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
		String a,b,c;
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			a = st.nextToken(); st.nextToken();
			b = st.nextToken(); st.nextToken();
			c = st.nextToken();
			out.write(getBase(a,b,c) + "\n");
		}
		out.flush();
	}
	static int getBase(String a,String b,String c) {
		if(onlyOne(a) && onlyOne(b) && onlyOne(c) && a.length() + b.length() == c.length())	return 1;
		int base = 2;
		for(int i = 0;i < a.length();i++)	base = Math.max(base,a.charAt(i) - '0' + 1);
		for(int i = 0;i < b.length();i++)	base = Math.max(base,b.charAt(i) - '0' + 1);
		for(int i = 0;i < c.length();i++)	base = Math.max(base,c.charAt(i) - '0' + 1);
		while(base <= 36) {
			if(Long.parseLong(a,base) + Long.parseLong(b,base) == Long.parseLong(c,base))
				return base;
			base++;
		}
		return 0;
	}
	static boolean onlyOne(String s) {
		for(int i = 0;i < s.length();i++) if(s.charAt(i) != '1')
			return false;
		return true;
	}
}
