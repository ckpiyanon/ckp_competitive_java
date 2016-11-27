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
		int[][] arr = new int[76][76];
		int TC = getInt(),n;
		while(TC-- > 0) {
			n = getInt();
			for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++)
				arr[i][j] = getInt();
			for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++) arr[i][j] += arr[i][j-1];
			for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++) arr[i][j] += arr[i-1][j];
			int max = Integer.MIN_VALUE;
			for(int r0 = 0;r0 <= n;r0++) for(int c0 = 0;c0 <= n;c0++)
				for(int r1 = r0;r1 <= n;r1++) for(int c1 = c0;c1 <= n;c1++) {
					int mid = arr[r1][c1] - arr[r1][c0] - arr[r0][c1] + arr[r0][c0];
					int ver = arr[r1][n] - arr[r0][n] - mid;
					int hor = arr[n][c1] - arr[n][c0] - mid;
					int cor = arr[n][n] - ver - hor - mid;
					max = Math.max(max,mid);
					max = Math.max(max,ver);
					max = Math.max(max,hor);
					max = Math.max(max,cor);
				}
			out.write(max + "\n");
		}
		out.flush();
	}
}
