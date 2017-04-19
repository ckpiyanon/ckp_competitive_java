import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.BitSet;

public class Main {
	static final int MAX = 10001;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet primeSet = new BitSet(MAX);
		int a,b;
		primeSet.set(2,MAX);
		for(int i = 4;i < MAX;i += 2)	primeSet.set(i,false);
		for(int i = 3;i*i < MAX;i += 2) if(primeSet.get(i))
			for(int j = i*i;j < MAX;j += i+i)	primeSet.set(j,false);
		int TC = getInt();
		while(TC-- > 0) {
			a = getInt(); b = getInt();
		}
		out.flush();
	}
}
