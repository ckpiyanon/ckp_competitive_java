import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC,N,x,p,pos,cnt,ans,t;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		TC = getInt();
		while(TC-- > 0) {
			N = getInt();
			map.clear();
			p = pos = cnt = ans = 0;
			while(N-- > 0) {
				x = getInt();
				if(map.containsKey(x) && (t = map.get(x)) >= p) {
					ans = Math.max(ans,cnt);
					cnt -= t - p;
					p = t + 1;
					map.put(x,pos++);
				}
				else {
					map.put(x,pos++);
					cnt++;
				}
			}
			System.out.println(Math.max(ans,cnt));
		}
	}
}
