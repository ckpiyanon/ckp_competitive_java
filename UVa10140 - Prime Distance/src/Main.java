import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	static final int MAX = 47000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int l,r;
		isPrime.set(2,MAX);
		for(int i = 4;i < MAX;i += 2)	isPrime.set(i,false);
		for(int i = 3;i*i < MAX;i += 2) if(isPrime.get(i))
			for(int j = i*i;j < MAX;j += i + i)
				isPrime.set(j,false);
		for(int i = 2;i < MAX;i = i == 2 ? 3:i + 2)
			if(isPrime.get(i))
				prime.add(i);
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			l = (int)st.nval; r = getInt();
			while(!isPrime(l))	l++;
			int prev = l++,min = Integer.MAX_VALUE,max = 0,ansMin = 0,ansMax = 0;
			for(;l > 0 && l <= r;l++) if(isPrime(l)) {
				if(min > l - prev) {ansMin = prev; min = l - prev;}
				if(max < l - prev) {ansMax = prev; max = l - prev;}
				prev = l;
			}
			if(ansMin == 0)	out.write("There are no adjacent primes.\n");
			else	out.write(ansMin + "," + (ansMin + min) + " are closest, " + ansMax + "," + (ansMax + max) + " are most distant.\n");
		}
		out.flush();
	}
	static BitSet isPrime = new BitSet(MAX);
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	static boolean isPrime(int n) {
		if(n < MAX)	return isPrime.get(n);
		for(int i = 0;i < prime.size() && prime.get(i) * prime.get(i) <= n;i++)
			if(n % prime.get(i) == 0)
				return false;
		return true;
	}
}
