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
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		BitSet prime = new BitSet(65537);
		prime.set(2,prime.size());
		for(int i = 4;i < prime.size();i += 2)	prime.set(i,false);
		for(int i = 3;i*i < prime.size();i += 2) if(prime.get(i))
			for(int j = i*i;j < prime.size();j += i+i)
				prime.set(j,false);
		primeList.add(2);
		for(int i = 3;i < prime.size();i++) if(prime.get(i))	primeList.add(i);
		int n;
		while((n = Integer.parseInt(in.readLine())) != 0) {
			boolean first = true;
			out.write(n + " = ");
			if(n < 0) {out.write("-1"); first = false; n = -n;}
			for(int i = 0;i < primeList.size() && primeList.get(i) <= n;i++) {
				while(n % primeList.get(i) == 0) {
					if(!first)	out.write(" x ");
					first = false;
					out.write(primeList.get(i).toString());
					n /= primeList.get(i);
				}
			}
			if(n != 1 && isPrime(n,primeList)) {
				if(!first)	out.write(" x ");
				out.write(String.valueOf(n));
			}
			out.write("\n");
		}
		out.flush();
	}
	static boolean isPrime(int n,ArrayList<Integer> list) {
		for(int i = 0;i < list.size() && list.get(i)*list.get(i) <= n;i++)
			if(n % list.get(i) == 0)
				return false;
		return true;
	}
}
