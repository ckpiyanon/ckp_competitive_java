import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	static final int MAX = 1120;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet isPrime = new BitSet(MAX);
		isPrime.set(2,MAX);
		for(int i = 4;i < MAX;i += 2)	isPrime.set(i,false);
		for(int i = 3;i*i < MAX;i += 2) if(isPrime.get(i))
			for(int j = i*i;j < MAX;j += i + i)
				isPrime.set(j,false);
		list = new ArrayList<Integer>(isPrime.cardinality());
		for(int i = 2;i < MAX;i = i == 2 ? 3:i + 2) if(isPrime.get(i))
			list.add(i);
		int n,k;
	}
	static ArrayList<Integer> list;
}
