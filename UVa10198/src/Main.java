import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger[] arr = new BigInteger[1001];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.valueOf(2);
		arr[2] = BigInteger.valueOf(5);
		arr[3] = BigInteger.valueOf(13);
		for(int i = 4;i <= 1000;i++)	arr[i] = arr[i-1].add(arr[i-1]).add(arr[i-2]).add(arr[i-3]);
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			out.write(arr[(int)in.nval].toString());
			out.write("\n");
		}
		out.flush();
	}
}
