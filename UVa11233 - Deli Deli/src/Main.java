import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	static StreamTokenizer st;
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<String,String> map = new TreeMap<String,String>();
		String s,ans;
		int n = getInt(),q = getInt();
		while(n-- > 0)	map.put(getString(),getString());
		while(q-- > 0) {
			if((ans = map.get(s = getString())) == null) {
				if(s.charAt(s.length() - 1) == 'y' && !isVowel(s.charAt(s.length() - 2)))
					ans = s.substring(0,s.length() - 1) + "ies";
				else if(appendEs(s))
					ans = s + "es";
				else
					ans = s + 's';
			}
			out.write(ans + "\n");
		}
		out.flush();
	}
	static boolean appendEs(String s) {
		int len = s.length();
		char ch1 = s.charAt(len - 2),ch2 = s.charAt(len - 1);
		return ch2 == 'o' || ch2 == 's' || ch2 == 'x' || (ch2 == 'h' && (ch1 == 's' || ch1 == 'c'));
	}
	static boolean isVowel(char ch) {return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';}
}
