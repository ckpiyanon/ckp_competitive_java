import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;

public class Main {
	static final int MAX = 1000000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet isPrime = new BitSet(MAX);
		ArrayList<Integer> prime = new ArrayList<Integer>();
		isPrime.set(2,MAX);
		for(int i = 4;i < MAX;i += 2)	isPrime.set(i,false);
		for(int i = 3;i*i < MAX;i += 2) if(isPrime.get(i))
			for(int j = i*i;j < MAX;j += i + i)
				isPrime.set(j,false);
		for(int i = 2;i < MAX;i = i == 2 ? 3:i + 2) if(isPrime.get(i))
			prime.add(i);
		int TC = getInt(),l,r;
		int[] arr = new int[200];
		while(TC-- > 0) {
			l = getInt(); r = getInt();
			int b = Collections.binarySearch(prime,l);
			int e = Collections.binarySearch(prime,r);
			if(b < 0)	b = Math.abs(b) - 1;
			if(e < 0)	e = Math.abs(e) - 2;
			Arrays.fill(arr,0);
			for(int i = b;i < e;i++)
				arr[prime.get(i+1) - prime.get(i)]++;
			int ans = 0;
			for(int i = 1;i < arr.length;i++) if(arr[i] > arr[ans])
				ans = i;
			if(ans > 0 && count(arr,arr[ans]) == 1)
				out.write("The jumping champion is " + ans + "\n");
			else	out.write("No jumping champion\n");
		}
		out.flush();
	}
	static int count(int[] arr,int n) {
		int ret = 0;
		for(int x:arr) if(x == n) ret++;
		return ret;
	}
}
