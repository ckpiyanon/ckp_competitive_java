import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n,q,TC = 0,pos[] = new int[10001];
		while((n = getInt()) != 0 && (q = getInt()) != 0) {
			list.clear();
			while(n-- > 0) list.add(getInt());
			Collections.sort(list);
			Arrays.fill(pos,-1);
			for(int i = 0;i < list.size();i++)
				if(pos[list.get(i)] == -1)
					pos[list.get(i)] = i + 1;
			System.out.println("CASE# " + ++TC + ":");
			while(q-- > 0) {
				n = getInt();
				if(pos[n] != -1)	System.out.println(n + " found at " + pos[n]);
				else System.out.println(n + " not found");
			}
		}
	}
}
