import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> prime = new ArrayList<Integer>();
		BitSet isPrime = new BitSet(32768);
		int n;
		isPrime.set(0,32768);
		for(int i = 2;i < 32768;i = i == 2 ? 3:i+2) if(isPrime.get(i)) {
			prime.add(i);
			for(int j = i + i;j < 32768;j += i)
				isPrime.set(j,false);
		}
		while((n = Integer.parseInt(in.readLine())) != 0) {
			int ans = 0;
			for(int i = 0;i < prime.size() && prime.get(i) + prime.get(i) <= n;i++)
				if(Collections.binarySearch(prime,n - prime.get(i)) >= 0)
					ans++;
			out.write(ans + "\n");
		}
		out.flush();
	}
}
