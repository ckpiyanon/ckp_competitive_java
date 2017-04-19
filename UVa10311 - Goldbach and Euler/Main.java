import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

public class Main {
	static final int MAX = 100000001;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet isPrime = new BitSet(MAX);
		String str;
		isPrime.set(0,MAX); isPrime.set(0,false); isPrime.set(1,false);
		for(int i = 4;i < MAX;i += 2)	isPrime.set(i,false);
		for(int i = 3;i*i < MAX;i += 2) if(isPrime.get(i)) {
			int s = i + i;
			for(int j = i*i;j < MAX;j += s)
				isPrime.set(j,false);
		}
		for(int i = 2;i < MAX;i++) if(isPrime.get(i)) prime.add(i);
		int n;
		while((str = in.readLine()) != null) {
			n = Integer.parseInt(str);
			int ans = 0;
			if(n % 2 == 1)	ans = n > 3 && isPrime.get(n - 2) ? 2:0;
			else {
				int i = Math.abs(Collections.binarySearch(prime,n / 2));
				while(i >= 0 && prime.get(i) >= n / 2)	i--;
				for(;i >= 0 && ans == 0;i--)
					if(isPrime.get(n - prime.get(i)))
						ans = prime.get(i);
			}
			if(ans == 0)	out.write(n + " is not the sum of two primes!\n");
			else	out.write(n + " is the sum of " + ans + " and " + (n - ans) + ".\n");
		}
		out.flush();
	}
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	static boolean isPrime(int n) {
		for(int i = 0;i < prime.size() && prime.get(i) * prime.get(i) <= n;i++)
			if(n % prime.get(i) == 0)	return false;
		return true;
	}
}
