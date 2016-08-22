import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int x,y,a,sn,s[][] = new int[3][2];
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			x = (int)st.nval; st.nextToken(); y = (int)st.nval;
			s[0][0] = s[1][1] = 1; s[0][1] = s[1][0] = 0;
			while(x % y != 0) {
				a = x / y;
				sn = x % y;
				s[2][0] = s[0][0] - a*s[1][0];
				s[2][1] = s[0][1] - a*s[1][1];
				s[0][0] = s[1][0]; s[0][1] = s[1][1];
				s[1][0] = s[2][0]; s[1][1] = s[2][1];
				x = y; y = sn;
			}
			System.out.println(s[1][0] + " " + s[1][1] + " " + y);
		}
	}
}
