import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		while((s = in.readLine()) != null) {
			for(int i = 15;i >= 2;i--) {
				if(i < 15)	out.write(" ");
				try {int n = count(new BigInteger(s,i),i); out.write(String.valueOf(n));}
				catch(NumberFormatException e) {out.write("?");}
			}
			out.write("\n");
		}
		out.flush();
	}
	static int count(BigInteger n,int radix) {
		int ans = 0;
		String s;
		while(!isPalin(s = n.toString(radix))) {
			n = n.add(new BigInteger(reverse(s),radix));
			ans++;
		}
		return ans;
	}
	static String reverse(String s) {
		char[] ret = s.toCharArray();
		for(int i = 0,j = s.length() - 1;i < j;i++,j--) {
			char ch = ret[i];
			ret[i] = ret[j];
			ret[j] = ch;
		}
		return new String(ret);
	}
	static boolean isPalin(String s) {
		for(int i = 0;i < s.length() / 2;i++)
			if(s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		return true;
	}
}
