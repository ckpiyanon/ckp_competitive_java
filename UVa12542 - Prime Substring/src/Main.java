import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

public class Main {
	static final int MAX = 100000;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet isPrime = new BitSet(MAX);
		String s;
		int max,n;
		isPrime.set(2,MAX);
		for(int i = 4;i < MAX;i += 2)	isPrime.set(i,false);
		for(int i = 3;i*i < MAX;i += 2) if(isPrime.get(i))
			for(int j = i*i;j < MAX;j += i + i)
				isPrime.set(j,false);
		while(!(s = in.readLine()).equals("0")) {
			max = 2;
			for(int i = 0;i < s.length();i++) {
				n = 0;
				for(int j = i;j < s.length() && j - i < 6;j++) {
					n = n * 10 + s.charAt(j) - '0';
					if(n < MAX && isPrime.get(n) && max < n)	max = n;
				}
			}
			out.write(max + "\n");
		}
		out.flush();
	}
}
