import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,ans;
		while((n = Integer.parseInt(in.readLine())) != 0) {
			ans = 0;
			for(int i = 0;i <= 3;i++)	ans = Math.max(ans,calc(n,i));
			out.write(ans + "\n");
		}
		out.flush();
	}
	static int calc(int n,int b) {
		n += b;
		int ret = 0;
		while(n >= 3 && (n / 3) + (n % 3) >= b) {
			ret += n / 3;
			n = (n / 3) + (n % 3);
		}
		return ret;
	}
}
