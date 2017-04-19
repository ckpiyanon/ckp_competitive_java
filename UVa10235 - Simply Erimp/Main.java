import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

public class Main {
	public static void main(String args[]) throws Exception {
		final int MAX = 1000001;
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s,t;
		BitSet isPrime = new BitSet(MAX);
		isPrime.set(0,MAX); isPrime.set(0,false); isPrime.set(1,false);
		for(int i = 4;i < MAX;i += 2)	isPrime.set(i,false);
		for(int i = 3;i*i < MAX;i += 2) if(isPrime.get(i))
			for(int j = i*i;j < MAX;j += i + i)
				isPrime.set(j,false);
		while((s = in.readLine()) != null) {
			t = new StringBuilder(s).reverse().toString();
			out.write(s + " is " + (isPrime.get(Integer.parseInt(s)) ? (!t.equals(s) && isPrime.get(Integer.parseInt(t)) ? "emirp":"prime"):"not prime") + ".\n");
		}
		out.flush();
	}
}
