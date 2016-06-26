import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		new Main().run();
	}
	int cal(char[] s) {
		int i = 0,m = s.length;
		int[] p = new int[m+1];
		p[0] = p[1] = 0;
		for(int j = 2;j <= m;j++) {
			while(i > 0 && s[i] != s[j-1])	i = p[i];
			if(s[i] == s[j-1])	i++;
			p[j] = i;
		}
		return m / (m - p[m]);
	}
	void run() throws Exception {
		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(true) {
			s = in.readLine();
			if(s.charAt(0) == '.')	break;
			System.out.println(cal(s.toCharArray()));
		}
		in.close();
	}
}
