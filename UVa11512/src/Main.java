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
	static boolean match(String a,String b) {
		if(a.length() > b.length())	return false;
		for(int i = 0;i < a.length();i++)
			if(a.charAt(i) != b.charAt(i))
				return false;
		return true;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> sa = new ArrayList<String>();
		int TC = Integer.parseInt(in.readLine()),len,max,t;
		String s;
		while(TC-- > 0) {
			sa.clear();
			len = (s = in.readLine()).length();
			for(int i = 0;i <= len;i++)	sa.add(s.substring(i));
			Collections.sort(sa);
			max = 0;
			for(int i = 1;i < len;i++) {
				t = calc(sa.get(i),sa.get(i+1));
				if(max < t) {
					max = t;
					s = sa.get(i).substring(0,max);
				}
			}
			t = 0;
			int i = 0;
			while(!match(s,sa.get(i)))	i++;
			while(i <= len && match(s,sa.get(i++)))	t++;
			if(max == 0)	System.out.println("No repetitions found!");
			else	System.out.println(s + " " + t);
		}
	}
}
