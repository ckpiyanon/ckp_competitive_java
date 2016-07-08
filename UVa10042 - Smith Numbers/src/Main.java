import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	static void cal() {
		prime = new ArrayList<Integer>();
		BitSet isPrime = new BitSet(100000);
		isPrime.flip(0,isPrime.size());
		for(int i = 2;i < 100000;i = i == 2 ? 3:(i + 2))
			for(int j = i + i;j < 100000;j += i)
				isPrime.set(j,false);
		for(int i = 2;i < 100000;i++)
			if(isPrime.get(i))
				prime.add(i);
	}
	static boolean isPrime(int n) {
		for(Integer p:prime) {
			if(n == p)
				return true;
			if(n % p == 0)
				return false;
		}
		return true;
	}
	static int dp[] = new int[10000000];
	static int sumFactor(int n) {
		if(n < 10000000 && dp[n] != 0)	return dp[n];
		if(isPrime(n)) {
			int ans = sumDigit(n);
			if(n < 10000000)	dp[n] = ans;
			return ans;
		}
		for(int i = 0;i < prime.size();i++)
			if(n % prime.get(i) == 0) {
				int ans = sumFactor(n / prime.get(i)) + sumDigit(prime.get(i));
				if(n < 10000000)	dp[n] = ans;
				return ans;
			}
		return 0;
	}
	static int sumDigit(int n) {
		if(n == 1)	return 0;
		int sum = 0;
		while(n != 0) {sum += n % 10; n /= 10;}
		return sum;
	}
	
	static ArrayList<Integer> prime;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine()),n; cal();
		while(TC-- > 0) {
			n = Integer.parseInt(in.readLine()) + 1;
			while(isPrime(n) || sumDigit(n) != sumFactor(n))	n++;
			System.out.println(n);
		}
	}
}
