import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static boolean palin(char[] s) {
		int len = s.length / 2;
		for(int i = 0;i < len;i++)	if(s[i] != s[s.length - i - 1])	return false;
		return true;
	}
	static String rev(String s) {
		char a[] = s.toCharArray(),c;
		int len = a.length / 2;
		for(int i = 0;i < len;i++) {
			c = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = c;
		}
		return new String(a);
	}
	static String comp(String s) {
		int n = 0;
		while(!palin(s.toCharArray())) {
			s = String.valueOf(Long.parseLong(s) + Long.parseLong(rev(s)));
			n++;
		}
		s = n + " " + s + "\n";
		return s;
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0)	out.write(comp(in.readLine()));
		out.flush();
	}
}
