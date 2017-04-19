import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int calc(String a,String b) {
		int i = 0,len = Math.min(a.length(),b.length());
		while(i < len && a.charAt(i) == b.charAt(i))	i++;
		return i;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine()),len,max;
		String s;
		ArrayList<String> sa = new ArrayList<String>();
		while(TC-- > 0) {
			sa.clear();
			len = (s = in.readLine()).length();
			for(int i = 0;i <= len;i++)	sa.add(s.substring(i));
			Collections.sort(sa);
			max = 0;
			for(int i = 0;i < len;i++)	max = Math.max(max,calc(sa.get(i),sa.get(i+1)));
			System.out.println(max);
		}
	}
}
