import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static final int MAX = 10001;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> prime = new ArrayList<Integer>();
		boolean isPrime[] = new boolean[MAX];
		int n,ans;
		Arrays.fill(isPrime,true);
		isPrime[0] = isPrime[1] = false;
		prime.add(0); prime.add(2);
		for(int i = 4;i < MAX;i += 2)	isPrime[i] = false;
		for(int i = 3;i*i < MAX;i += 2) if(isPrime[i])
			for(int j = i*i;j < MAX;j += i+i)
				isPrime[j] = false;
		for(int i = 3;i < MAX;i += 2) if(isPrime[i])
			prime.add(i + prime.get(prime.size() - 1));
		while((n = Integer.parseInt(in.readLine())) != 0) {
			ans = 0;
			for(int i = 0;i < prime.size();i++) for(int j = i + 1;j < prime.size() && prime.get(j) - prime.get(i) <= n;j++) {
				if(prime.get(j) - prime.get(i) == n)	ans++;
			}
			out.write(ans + "\n");
		}
		out.flush();
	}
}
