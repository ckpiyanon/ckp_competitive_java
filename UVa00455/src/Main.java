import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static int calc(char[] s,char[] t) {
		int m = s.length,n = t.length,p[] = new int[m+1];
		p[0] = p[1] = 0;
		for(int i = 0,j = 2;j <= m;j++) {
			while(i > 0 && s[i] != s[j-1])	i = p[i];
			if(s[i] == s[j-1])	i++;
			p[j] = i;
		}
		for(int i = 0,j = 1;j < n;j++) {
			while(i > 0 && s[i] != t[j])	i = p[i];
			if(s[i] == t[j])	i++;
			if(i == m)	return j + 1 - m;
		}
		return -1;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st.nextToken();
		int TC = (int)st.nval;
		String s;
		while(TC-- > 0) {
			st.nextToken();
			s = st.sval;
			out.write(String.valueOf(calc(s.toCharArray(),(s+s).toCharArray())));
			out.write('\n');
			if(TC > 0)	out.write('\n');
		}
		out.flush();
		out.close();
	}
}