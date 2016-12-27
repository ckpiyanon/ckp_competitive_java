import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	static StreamTokenizer st;
	static final int MAX = 32000;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		primeSet = new BitSet(MAX);
		primeSet.set(0,primeSet.size());
		primeSet.set(0,false); primeSet.set(1,false);
		for(int i = 4;i < MAX;i += 2)	primeSet.set(i,false);
		for(int i = 3;i*i < MAX;i += 2) if(primeSet.get(i))
			for(int j = i*i;j < MAX;j += i + i)
				primeSet.set(j,false);
		primes.add(2);
		for(int i = 3;i < MAX;i += 2) if(primeSet.get(i))
			primes.add(i);
		int p,a;
		while(((p = getInt()) != 0) & ((a = getInt()) != 0)) {
			BigInteger bp = BigInteger.valueOf(p);
			BigInteger ba = BigInteger.valueOf(a);
			out.write(!isPrime(p) && ba.modPow(bp,bp).equals(ba) ? "yes\n":"no\n");
		}
		out.flush();
	}
	static BitSet primeSet;
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static boolean isPrime(int n) {
		if(n < primeSet.size())	return primeSet.get(n);
		for(int i = 0;i < primes.size() && primes.get(i)*primes.get(i) <= n;i++)
			if(n % primes.get(i) == 0)	return false;
		return true;
	}
}
