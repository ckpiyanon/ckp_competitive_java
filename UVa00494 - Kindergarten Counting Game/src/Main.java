import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		while((s = in.readLine()) != null) {
			int ans = 0;
			int i = 0;
			while(!isAlpha(s.charAt(i)))	i++;
			for(;i < s.length();i++) {
				while(i < s.length() && isAlpha(s.charAt(i)))	i++;
				ans++;
				while(i < s.length() && !isAlpha(s.charAt(i)))	i++;
			}
			out.write(ans + "\n");
		}
		out.flush();
	}
	static boolean isAlpha(char ch) {return Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z';}
}
