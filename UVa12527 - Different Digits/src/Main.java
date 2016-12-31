import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,m;
		int[] num = new int[5001];
		for(int i = 1;i <= 5000;i++)	num[i] = num[i-1] + (check(i) ? 1:0);
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval; st.nextToken(); m = (int)st.nval;
			out.write(num[m] - num[n-1] + "\n");
		}
		out.flush();
	}
	static boolean check(int n) {
		int[] num = new int[10];
		while(n != 0) {
			num[n % 10]++;
			n /= 10;
		}
		for(int i = 0;i < 10;i++) if(num[i] > 1) return false;
		return true;
	}
}
