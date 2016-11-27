import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static final int MAX = 21;
	static StreamTokenizer st;
	static double getNum() throws Exception {st.nextToken(); return st.nval;}
	static int getInt() throws Exception {return (int)getNum();}
	static long getLong() throws Exception {return (long)getNum();}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long[][][] arr = new long[MAX][MAX][MAX];
		int TC = getInt(),d0,d1,d2;
		long ans;
		while(TC-- > 0) {
			d0 = getInt(); d1 = getInt(); d2 = getInt();
			for(int i = 1;i <= d0;i++)
				for(int j = 1;j <= d1;j++)
					for(int k = 1;k <= d2;k++)
						arr[i][j][k] = getLong();
			for(int i = 1;i <= d0;i++) for(int j = 1;j <= d1;j++) for(int k = 1;k <= d2;k++)
				arr[i][j][k] += arr[i][j][k-1];
			for(int i = 1;i <= d0;i++) for(int j = 1;j <= d1;j++) for(int k = 1;k <= d2;k++)
				arr[i][j][k] += arr[i][j-1][k];
			for(int i = 1;i <= d0;i++) for(int j = 1;j <= d1;j++) for(int k = 1;k <= d2;k++)
				arr[i][j][k] += arr[i-1][j][k];
			ans = Long.MIN_VALUE;
			for(int l0 = 0;l0 < d0;l0++) for(int r0 = 0;r0 < d1;r0++) for(int c0 = 0;c0 < d2;c0++)
				for(int l1 = l0 + 1;l1 <= d0;l1++) for(int r1 = r0 + 1;r1 <= d1;r1++) for(int c1 = c0 + 1;c1 <= d2;c1++)
					ans = Math.max(ans,arr[l1][r1][c1] - arr[l1][r0][c1] - arr[l1][r1][c0] + arr[l1][r0][c0]
							- arr[l0][r1][c1] + arr[l0][r0][c1] + arr[l0][r1][c0] - arr[l0][r0][c0]);
			out.write(ans + "\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
}