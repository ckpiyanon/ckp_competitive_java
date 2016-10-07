import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		HashSet<Integer> set = new HashSet<Integer>();
		int TC,n,p,x;
		TC = getInt();
		while(TC-- > 0) {
			n = getInt(); p = getInt(); set.clear();
			while(p-- > 0) {
				x = getInt();
				for(int i = x - 1;i < n;i += x) if(i % 7 < 5)
					set.add(i);
			}
			System.out.println(set.size());
		}
	}
}
