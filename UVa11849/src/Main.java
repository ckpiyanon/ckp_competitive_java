import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N,M;
		HashSet<Integer> set = new HashSet<Integer>();
		while((N = getInt()) != 0 & (M = getInt()) != 0) {
			set.clear();
			while(N-- > 0)	set.add(getInt());
			while(M-- > 0)	if(set.contains(getInt())) N++;
			System.out.println(N + 1);
		}
	}
}
