import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		Map.Entry<String,Integer> ans;
		int n,len; String s,ss;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval; st.nextToken();
			len = (s = st.sval).length(); map.clear();
			for(int i = 0;i < len - n;i++) {
				ss = s.substring(i,i+n);
				if(map.containsKey(ss))	map.put(ss,map.get(ss) + 1);
				else	map.put(ss,1);
			}
			ans = null;
			for(Map.Entry<String,Integer> entry: map.entrySet()) {
				if(ans == null)	ans = entry;
				else if(ans.getValue() < entry.getValue())
					ans = entry;
			}
			System.out.println(ans.getKey());
		}
	}
}
