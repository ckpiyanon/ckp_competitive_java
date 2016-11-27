import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt(),n,m,k;
		long[][] arr = new long[101][101];
		for(int tc = 1;tc <= TC;tc++) {
			n = getInt(); m = getInt(); k = getInt();
			for(int i = 1;i <= n;i++) for(int j = 1;j <= m;j++) arr[i][j] = getInt();
			for(int i = 1;i <= n;i++) for(int j = 1;j <= m;j++) arr[i][j] += arr[i][j-1];
			for(int i = 1;i <= n;i++) for(int j = 1;j <= m;j++) arr[i][j] += arr[i-1][j];
			long max = 0,cost = 0;
			for(int r0 = 0;r0 < n;r0++) for(int c0 = 0;c0 < m;c0++)
				for(int r1 = r0 + 1;r1 <= n;r1++) for(int c1 = c0 + (int)Math.ceil(max * 1.0 / (r1 - r0));c1 <= m;c1++) {
					long sum = arr[r1][c1] - arr[r0][c1] - arr[r1][c0] + arr[r0][c0];
					int area = (r1 - r0) * (c1 - c0);
					if(sum <= k) {
						if(max < area) {max = area; cost = sum;}
						else if(max == area) cost = Math.min(cost,sum);
					}
				}
			out.write("Case #" + tc + ": " + max + " " + cost + "\n");
		}
		out.flush();
	}
}
