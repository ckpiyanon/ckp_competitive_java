import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class Main {
	static int p,c;
	static StreamTokenizer st;
	static HashMap<Integer,Integer> next,prev;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static char getChar() throws Exception {
		st.nextToken();
		return st.sval.charAt(0);
	}
	static int getNext(int n) {
		Integer x = next.get(n);
		if(x != null)	return x;
		if(n + 1 > p)	return 1;
		return n + 1;
	}
	static int getPrev(int n) {
		Integer x = prev.get(n);
		if(x != null)	return x;
		if(n - 1 < 1)	return p;
		return n - 1;
	}
	static void connect(int p,int n) {
		next.put(p,n);	prev.put(n,p);
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in1.txt"));
//		System.setOut(new PrintStream("out.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		next = new HashMap<Integer,Integer>();
		prev = new HashMap<Integer,Integer>();
		int TC = 0,now,last,e;
		while((p = getInt()) != 0 && (c = getInt()) != 0) {
			System.out.println("Case " + ++TC + ":");
			now = 1; last = p;
			next.clear(); prev.clear();
			while(c-- > 0) {
				if(getChar() == 'E') {
					e = getInt();
					if(e == now)	continue;
					if(e == last)	last = getPrev(last);
					connect(getPrev(e),getNext(e));
					connect(e,now);
					now = e;
				}
				else {
					System.out.println(now);
					connect(last,now);
					last = now;
					now = getNext(now);
				}
			}
		}
	}
}
