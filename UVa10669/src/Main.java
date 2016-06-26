import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		BigInteger[] S = new BigInteger[64];
		S[0] = BigInteger.ONE;
		BigInteger BIGTHREE = BigInteger.valueOf(3);
		for(int i = 1;i < 64;i++) S[i] = S[i-1].add(BIGTHREE);
		long n;
		StringBuilder sb;
		while((n = Long.parseLong(in.readLine()) - 1) >= 0) {
			sb = new StringBuilder("{");
			boolean first = true;
			for(int i = 0;n != 0;i++, n >>= 1) if((n & 1) == 1) {
				sb.append(first ? " ":", ").append(S[i]);
				first = false;
			}
			out.write(sb.append(" }\n").toString().getBytes());
		}
		out.flush();
	}
}
