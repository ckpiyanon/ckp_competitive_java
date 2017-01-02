import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet prime = new BitSet(65537);
		prime.set(2,prime.size());
		for(int i = 4;i < prime.size();i += 2)	prime.set(i,false);
		for(int i = 3;i*i < prime.size();i += 2) if(prime.get(i))
			for(int j = i*i;j < prime.size();j += i+i)
				prime.set(j,false);
		for(int i = 2;i < prime.size();i = i == 2 ? 3:i+2)
			if(prime.get(i))	primeList.add((long)i);
		long n;
		while((n = Integer.parseInt(in.readLine())) != 0) {
			if(!isPrime(n))	out.write("Given number is NOT prime! NO perfect number is available.\n");
			else if(!isPrime((1 << n) - 1))	out.write("Given number is prime. But, NO perfect number is available.\n");
			else	out.write("Perfect: " + ((1L << n) - 1L) * (1L << (n-1)) + "!\n");
		}
		out.flush();
	}
	static ArrayList<Long> primeList = new ArrayList<Long>();
	static boolean isPrime(long n) {
		for(int i = 0;i < primeList.size() && primeList.get(i)*primeList.get(i) <= n;i++)
			if(n % primeList.get(i) == 0)	return false;
		return true;
	}
}
