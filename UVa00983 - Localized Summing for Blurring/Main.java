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
		int n,m = -1;
		int[][] arr = new int[1001][1001];
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			if(m != -1)	out.write("\n");
			n = (int)st.nval; m = getInt();
			long sum = 0;
			for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++) arr[i][j] = getInt();
			for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++) arr[i][j] += arr[i][j-1];
			for(int i = 1;i <= n;i++) for(int j = 1;j <= n;j++) arr[i][j] += arr[i-1][j];
			for(int r = 0;r + m <= n;r++) for(int c = 0;c + m <= n;c++) {
				int tmp = arr[r + m][c + m] - arr[r][c + m] - arr[r + m][c] + arr[r][c];
				sum += tmp;
				out.write(tmp + "\n");
			}
			out.write(sum + "\n");
		}
		out.flush();
	}
}
