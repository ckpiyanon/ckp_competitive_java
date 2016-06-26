import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> set = new TreeSet<String>();
		String s;
		int i,j,len;
		while(in.ready()) {
			len = (s = in.readLine().toLowerCase()).length();
			i = 0;
			while(i < len) {
				while(i < len && (s.charAt(i) < 'a' || s.charAt(i) > 'z' && s.charAt(i) != '-'))	i++;
				if(i >= len)	break;
				j = i+1;
				while(j < len && ((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || s.charAt(j) == '-')) {
					j++;
					if(j == len-1 && s.charAt(j) == '-') {
						s = s.substring(i,len - 1) + in.readLine().toLowerCase();
						i = 0; j = i+1;
						len = s.length();
					}
				}
				set.add(s.substring(i,j));
				i = j;
			}
		}
		for(String each:set)	System.out.println(each);
	}
}
