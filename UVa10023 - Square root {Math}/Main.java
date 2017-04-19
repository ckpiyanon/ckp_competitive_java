import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<Integer>();
		BigInteger bi,rem;
		String s;
		int TC = Integer.parseInt(in.readLine());
		for(int i = 0;i <= 100;i++)	val[i] = BigInteger.valueOf(i);
		while(TC-- > 0) {
			in.readLine(); s = in.readLine();
			list.clear();
			if(s.length() % 2 == 1)	list.add(s.charAt(0) - '0');
			for(int i = s.length() % 2;i + 2 <= s.length();i += 2)
				list.add(Integer.parseInt(s.substring(i,i+2)));
			bi = val[(int)Math.sqrt(list.get(0))];
			rem = val[list.get(0) - (int)Math.pow(Math.floor(Math.sqrt(list.get(0))),2)];
			for(int i = 1;i < list.size();i++) {
				bi = bi.multiply(val[10]).add(val[find(rem = rem.multiply(val[100]).add(val[list.get(i)]),bi.multiply(val[20]))]);
				rem = rem.subtract(x);
			}
			out.write(bi + "\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
	static BigInteger[] val = new BigInteger[101];
	static BigInteger x;
	static int find(BigInteger r,BigInteger n) {
		for(int i = 9;i >= 0;i--)
			if((x = n.add(val[i]).multiply(val[i])).compareTo(r) <= 0)
				return i;
		return 0;
	}
}
