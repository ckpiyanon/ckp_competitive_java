import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e){}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int map[] = new int[256];
		int TC = Integer.parseInt(in.readLine()),n;
		char s[];
		double sum;
		while(TC-- > 0) {
			Arrays.fill(map,0);
			n = Integer.parseInt(in.readLine());
			while(n-- > 0) {
				st = new StringTokenizer(in.readLine());
				map[st.nextToken().charAt(0)] = Integer.parseInt(st.nextToken());
			}
			n = Integer.parseInt(in.readLine());
			sum = 0;
			while(n-- > 0) {
				s = in.readLine().toCharArray();
				for(char c:s)	sum += map[c];
			}
			System.out.printf("%.2f$\n",sum / 100.0);
		}
	}
}
