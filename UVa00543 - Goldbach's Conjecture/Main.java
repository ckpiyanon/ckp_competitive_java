import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	static final int MAX = 1001;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet isPrime = new BitSet(MAX);
		int N;
		isPrime.set(0,MAX);
		for(int i = 2;i < MAX;i = i == 2 ? 3:i+2) if(isPrime.get(i)) {
			prime.add(i);
			for(int j = i + i;j < MAX;j += i)
				isPrime.set(j,false);
		}
		while((N = Integer.parseInt(in.readLine())) != 0) {
			for(Integer n:prime) if(checkPrime(N - n)) {
				out.write(N + " = " + n + " + " + (N - n) + "\n");
				break;
			}
		}
		out.flush();
	}
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	static boolean checkPrime(int n) {
		for(int i = 0;i < prime.size() && prime.get(i) * prime.get(i) <= n;i++)
			if(n % prime.get(i) == 0)
				return false;
		return true;
	}
}
