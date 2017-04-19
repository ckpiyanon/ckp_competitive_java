import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int TC = Integer.parseInt(in.readLine()),n;
		int[][] arr = new int[26][26];
		in.readLine();
		while(TC-- > 0) {
			n = 0;
			while((str = in.readLine()) != null && str.length() > 0) {
				for(int i = 1;i <= str.length();i++) arr[n+1][i] = str.charAt(i-1) - '0';
				n++;
			}
			for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++) arr[i][j] += arr[i][j-1];
			for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++) arr[i][j] += arr[i-1][j];
			int ans = 0;
			for(int r0 = 0;r0 < n;r0++) for(int c0 = 0;c0 < n;c0++)
				for(int r1 = r0 + 1;r1 <= n;r1++) for(int c1 = c0 + 1;c1 <= n;c1++) {
					int sum = arr[r1][c1] - arr[r1][c0] - arr[r0][c1] + arr[r0][c0];
					if(sum == (r1 - r0)*(c1 - c0) && sum > ans)	ans = sum;
				}
			out.write(ans + "\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
}
