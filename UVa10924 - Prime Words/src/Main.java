import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 1041;
		boolean[] isPrime = new boolean[MAX];
		Arrays.fill(isPrime,true);
		for(int i = 4;i < MAX;i += 2)	isPrime[i] = false;
		for(int i = 3;i*i < MAX;i += 2)
			if(isPrime[i]) for(int j = i*i;j < MAX;j += i+i)
				isPrime[j] = false;
		int[] val = new int[123];
		for(char ch = 'a';ch <= 'z';ch++) {
			val[ch] = ch - 'a' + 1;
			val[Character.toUpperCase(ch)] = ch - 'a' + 27;
		}
		String s;
		while((s = in.readLine()) != null) {
			int sum = 0;
			for(int i = 0;i < s.length();i++)	sum += val[s.charAt(i)];
			out.write("It is " + (isPrime[sum] ? "":"not ") + "a prime word.\n");
		}
		out.flush();
	}
}
