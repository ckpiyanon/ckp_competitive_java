import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int play(int n) {
		int ones = 1;
		int cnt = 1;
		while(true) {
			ones %= n;
			if(ones == 0)
				break;
			ones = ones*10 + 1;
			cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedInputStream in = new BufferedInputStream(System.in);
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		byte[] by = new byte[10000];
		int nin = in.read(by);
		String sin = new String(by,0,nin);
		StringTokenizer tok = new StringTokenizer(sin);
		while(tok.hasMoreTokens()) {
			out.write(new String(play(Integer.parseInt(tok.nextToken())) + "\n").getBytes());
		}
		out.flush();
		in.close();
		out.close();
	}
}
