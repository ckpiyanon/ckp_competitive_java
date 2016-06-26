import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int tree(int start,int sum) {
		if(str.charAt(start+1) == ')')	return -1;
		int lb = start + 1,n = 1;
		while(str.charAt(lb) != '(')	lb++;
		int rb = lb + 1;
		while(n > 0) {
			if(str.charAt(rb) == '(')	n++;
			if(str.charAt(rb) == ')')	n--;
			rb++;
		}
		sum += Integer.parseInt(str.substring(start+1,lb));
		int l = tree(lb,sum);
		int r = tree(rb,sum);
		if(l == -1 && r == -1 && sum == total)	ans = true;
		return 0;
	}
	static String str;
	static boolean ans;
	static int total;
	static void compute(String s) {
		int l = 0;
		while(s.charAt(l) != '(')	l++;
		total = Integer.parseInt(s.substring(0,l));
		ans = false;
		str = s;
		tree(l,0);
		System.out.println(ans ? "yes":"no");
	}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = 0;
		while(in.ready()) {
			char c = (char)in.read();
			if(c == '(')	n++;
			if(c == ')')	n--;
			if(c == ' ' || c == '\n' || c == (char)13)	continue;
			sb.append(c);
			if(n == 0 && sb.indexOf("(") != -1) {
				compute(sb.toString());
				sb = new StringBuilder();
			}
		}
	}
}
