import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger[] f = new BigInteger[5001];
		f[0] = BigInteger.ZERO; f[1] = BigInteger.ONE;
		for(int i = 2;i <= 5000;i++)	f[i] = f[i-1].add(f[i-2]);
		while(st.nextToken() != StreamTokenizer.TT_EOF)
			out.write("The Fibonacci number for " + (int)st.nval + " is " + f[(int)st.nval] + "\n");
		out.flush();
	}
}
