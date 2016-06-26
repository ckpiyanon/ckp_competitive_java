import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> set = new TreeSet<String>();
		char s[];
		int i,j,len;
		while(in.ready()) {
			len = (s = in.readLine().toLowerCase().toCharArray()).length;
			i = 0;
			while(i < len) {
				while(i < len && (s[i] < 'a' || s[i] > 'z'))	i++;
				if(i >= len)	break;
				j = i+1;
				while(j < len && s[j] >= 'a' && s[j] <= 'z')	j++;
				set.add(new String(Arrays.copyOfRange(s,i,j)));
				i = j;
			}
		}
		for(String each:set)	System.out.println(each);
	}
}
