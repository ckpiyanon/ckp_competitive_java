import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s,s1,s2;
		BigInteger[] list1 = new BigInteger[37];
		BigInteger[] list2 = new BigInteger[37];
		int[] base = new int[256];
		int b1,b2,ans1,ans2;
		char ch;
		for(ch = '1';ch <= '9';ch++)	base[ch] = ch - '0' + 1;
		for(ch = 'a';ch <= 'z';ch++)	base[ch] = base[Character.toUpperCase(ch)] = ch - 'a' + 11;
		base['0'] = 2;
		while((s = in.readLine()) != null) {
			st = new StringTokenizer(s);
			s1 = st.nextToken(); s2 = st.nextToken();
			ch = '0';
			for(int i = 0;i < s1.length();i++)	ch = (char)Math.max(ch,s1.charAt(i));
			b1 = base[ch];
			for(int i = b1;i <= 36;i++)	list1[i] = new BigInteger(s1,i);
			ch = '0';
			for(int i = 0;i < s2.length();i++)	ch = (char)Math.max(ch,s2.charAt(i));
			b2 = base[ch];
			for(int i = b2;i <= 36;i++)	list2[i] = new BigInteger(s2,i);
			ans1 = ans2 = -1;
			for(int i = b1;i <= 36 && ans1 == -1;i++) for(int j = b2;j <= 36 && ans2 == -1;j++) if(list1[i].equals(list2[j])) {
				ans1 = i; ans2 = j;
			}
			if(ans1 != -1 && ans2 != -1)
				out.write(s1 + " (base " + ans1 + ") = " + s2 + " (base " + ans2 + ")\n");
			else
				out.write(s1 + " is not equal to " + s2 + " in any base 2..36\n");
		}
		out.flush();
	}
}
