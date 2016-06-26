import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int l,n,arr[] = new int[52],tbl[][] = new int[52][52],t;
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while((l = getInt()) != 0) {
			n = getInt();
			for(int i = 1;i <= n;i++)	arr[i] = getInt();
			arr[n+1] = l;
			for(int h = 2;h <= n+1;h++) {
				for(int i = 0;i + h <= n+1;i++) {
					t = Integer.MAX_VALUE;
					for(int j = i + 1;j < i + h;j++)
						t = Math.min(t,tbl[i][j] + tbl[j][i + h]);
					tbl[i][i + h] = t + (arr[i + h] - arr[i]);
				}
			}
			out.write("The minimum cutting is ");
			out.write(String.valueOf(tbl[0][n+1]));
			out.write(".\n");
		}
		out.flush();
	}
}
