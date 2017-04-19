import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	static final int MAX = 20000001;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		BitSet isPrime = new BitSet(MAX);
		ArrayList<Integer> prime = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		isPrime.set(0,MAX); isPrime.set(0,false); isPrime.set(1,false);
		for(int i = 4;i < MAX;i += 2)	isPrime.set(i,false);
		for(int i = 3;i*i < MAX;i += 2)
			if(isPrime.get(i))
				for(int j = i*i;j < MAX;j += i + i)
					isPrime.set(j,false);
		for(int i = 2;i < MAX;i = i == 2 ? 3:i+2) if(isPrime.get(i))
			prime.add(i);
		for(int i = 1;i < prime.size();i++)
			if(prime.get(i) - prime.get(i - 1) == 2)
				ans.add(prime.get(i));
		while((str = in.readLine()) != null) {
			int n = Integer.parseInt(str) - 1;
			out.write("(" + (ans.get(n) - 2) + ", " + ans.get(n) + ")\n");
		}
		out.flush();
	}
}
