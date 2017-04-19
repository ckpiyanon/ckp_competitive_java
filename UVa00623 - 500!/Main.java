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
		BigInteger fact[] = new BigInteger[1001];
		fact[0] = BigInteger.ONE;
		for(int i = 1;i <= 1000;i++)	fact[i] = BigInteger.valueOf(i).multiply(fact[i-1]);
		while(in.ready()) {
			int n = Integer.parseInt(in.readLine());
			out.write(n + "!\n" + fact[n] + "\n");
		}
		out.flush();
	}
}
