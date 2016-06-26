import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int n,max,x;
		int[] arr = new int[5];
		String s;
		while((n = getInt()) != 0) {
			max = x = 1;
			map.clear();
			while(n-- > 0) {
				for(int j = 0;j < 5;j++)	arr[j] = getInt();
				Arrays.sort(arr);
				s = Arrays.toString(arr);
				if(map.containsKey(s)) {
					map.put(s,x = map.get(s) + 1);
				}
				else	map.put(s,1);
				max = Math.max(max,x);
			}
			n = 0;
			for(Map.Entry<String,Integer> entry:map.entrySet()) {
				if(entry.getValue() == max)	n += max;
			}
			System.out.println(n);
		}
	}
}
