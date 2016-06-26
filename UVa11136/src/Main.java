import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		int N,n;
		long ans;
		Integer v;
		Map.Entry<Integer,Integer> e1,e2;
		while((N = getInt()) != 0) {
			map.clear();
			ans = 0;
			while(N-- > 0) {
				n = getInt();
				while(n-- > 0) {
					if(!map.containsKey(v = getInt()))	map.put(v,1);
					else	map.put(v,map.get(v) + 1);
				}
				e1 = map.firstEntry();
				e2 = map.lastEntry();
				ans += e2.getKey() - e1.getKey();
				if(e1.getValue() == 1) map.remove(e1.getKey());
				else	map.put(e1.getKey(),e1.getValue() - 1);
				if(e2.getValue() == 1) map.remove(e2.getKey());
				else	map.put(e2.getKey(),e2.getValue() - 1);
			}
			System.out.println(ans);
		}
	}
}
