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
		while(in.ready()) {
			n = Integer.parseInt(in.readLine());
			ans = 0;
			for(int i = 0;i <= 3;i++)	ans = Math.max(ans,calc(n,i));
			out.write(ans + "\n");
		}
		out.flush();
	}
	static int calc(int num,int bor) {
		int ret = num,rem = bor + num;
		while(rem >= 3 && rem > bor && (rem / 3) + (rem % 3) >= bor) {
			ret += rem / 3;
			rem = (rem / 3) + (rem % 3);
		}
		return ret;
	}
}
