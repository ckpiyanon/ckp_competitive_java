import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt(),s,n;
		int[][] arr = new int[101][101];
		while(TC-- > 0) {
			for(int[] each:arr)	Arrays.fill(each,0);
			s = getInt(); n = getInt();
			while(n-- > 0) {
				int r0 = getInt(),c0 = getInt(),r1 = getInt(),c1 = getInt();
				for(int i = r0;i <= r1;i++) for(int j = c0;j <= c1;j++)
					arr[i][j] = 1;
			}
			for(int i = 1;i <= s;i++) for(int j = 1;j <= s;j++) arr[i][j] += arr[i][j-1];
			for(int i = 1;i <= s;i++) for(int j = 1;j <= s;j++) arr[i][j] += arr[i-1][j];
			int max = 0;
			for(int r0 = 0;r0 < s;r0++) for(int c0 = 0;c0 < s;c0++)
				for(int r1 = r0 + 1;r1 <= s;r1++) for(int c1 = c0 + 1;c1 <= s;c1++)
					if(arr[r1][c1] - arr[r1][c0] - arr[r0][c1] + arr[r0][c0] == 0)
						max = Math.max(max,(r1 - r0) * (c1 - c0));
			out.write(max + "\n");
		}
		out.flush();
	}
}
