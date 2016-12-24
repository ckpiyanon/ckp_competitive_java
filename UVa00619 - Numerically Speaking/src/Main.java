import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static final BigInteger M = BigInteger.valueOf(26);
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger bi;
		BigInteger AM[] = new BigInteger[25];
		String s,n;
		AM[0] = BigInteger.ONE;
		for(int i = 1;i < 25;i++)	AM[i] = AM[i-1].multiply(M);
		while((s = in.readLine()) != null && s.charAt(0) != '*') {
			if(Character.isDigit(s.charAt(0))) {
				StringBuilder sb = new StringBuilder();
				bi = new BigInteger(s);
				while(!bi.equals(BigInteger.ZERO)) {
					sb.append((char)(bi.mod(M).intValue() + 'a' - 1));
					bi = bi.divide(M);
				}
				n = s;
				s = sb.reverse().toString();
			}
			else {
				bi = BigInteger.ZERO;
				for(int i = 0;i < s.length();i++)
					bi = bi.add(BigInteger.valueOf(s.charAt(s.length() - i - 1) - 'a' + 1).multiply(AM[i]));
				n = bi.toString();
			}
			out.write(String.format("%-22s",s));
			for(int i = 0;i < n.length();i++) {
				out.write(n.charAt(i));
				if(((n.length() - i - 1) % 3) == 0 && i < n.length() - 1)
					out.write(',');
			}
			out.write("\n");
		}
		out.flush();
	}
}
