import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static final int MAX = 1100;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger[] fib = new BigInteger[MAX + 1];
		fib[0] = BigInteger.ZERO; fib[1] = BigInteger.ONE;
		for(int i = 2;i <= MAX;i++)	fib[i] = fib[i-1].add(fib[i-2]);
		while(in.ready())	out.write(fib[Integer.parseInt(in.readLine())] + "\n");
		out.flush();
	}
}
