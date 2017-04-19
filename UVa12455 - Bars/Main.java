import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),n,p,list[] = new int[20];
		boolean yes;
		while(TC-- > 0) {
			n = getInt(); p = getInt();
			for(int i = 0;i < p;i++)	list[i] = getInt();
			yes = false;
			for(int mask = 0;mask < (1 << p) && !yes;mask++) {
				int sum = 0;
				for(int i = 0;i < p;i++)	sum += ((1 << i) & mask) == 0 ? 0:list[i];
				if(sum == n)	yes = true;
			}
			System.out.println(yes ? "YES":"NO");
		}
	}
}
