import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static String getString() throws Exception {
		String s;
		if(st == null || !st.hasMoreTokens()) {
			s = br.readLine();
			if(s == null)	return null;
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}
	static Comparator<String> comp = new Comparator<String>() {
		public int compare(String s1,String s2) {
			if(s1.length() == s2.length())
				return s1.compareTo(s2);
			return s1.length() - s2.length();
		}
	};
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		TreeMap<String,Long> map = new TreeMap<String,Long>(comp);
		boolean yes = true;
		while((s = getString()) != null) {
			if(!s.equals("()")) {
				StringTokenizer st = new StringTokenizer(s,"(),");
				long val = Long.parseLong(st.nextToken());
				String pos = st.hasMoreTokens() ? st.nextToken():"";
				if(map.containsKey(pos))	yes = false;
				map.put(pos,val);
			}
			else {
				for(String pos:map.keySet()) {
					if(pos.equals(""))	continue;
					if(!map.containsKey(pos.substring(0,pos.length() - 1)))
						yes = false;
					if(!yes)	break;
				}
				System.out.println(yes ? map.toString().replaceAll("[\\{\\},RL=]",""):"not complete");
				yes = true;
				map.clear();
			}
		}
	}
}