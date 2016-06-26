import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while((n = getInt()) != 0) {
			list.clear();
			while(n-- > 0)	list.add(getInt());
			Collections.sort(list);
			System.out.println(list.toString().replace(", "," ").replace("[","").replace("]",""));
		}
	}
}
