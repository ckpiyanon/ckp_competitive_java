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
		boolean first = true;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			N = (int)st.nval;
			for(int i = 0;i < N*N;i++) for(int j = 0;j < N*N;j++) arr[i][j] = getInt();
			if(!first)	out.write("\n");
			first = false;
			if(solve(0,0)) {
				for(int i = 0;i < N*N;i++) {
					for(int j = 0;j < N*N;j++) {
						if(j > 0)	out.write(" ");
						out.write(String.valueOf(arr[i][j]));
					}
					out.write("\n");
				}
			}
			else	out.write("NO SOLUTION\n");
		}
		out.flush();
	}
	static int N;
	static int[][] arr = new int[9][9];
	static boolean solve(int r,int c) {
		if(c == N*N) {r++; c = 0;}
		if(r == N*N)	return true;
		if(arr[r][c] != 0)	return solve(r,c+1);
		for(int i = 1;i <= N*N;i++) {
			arr[r][c] = i;
			if(check(r,c) && solve(r,c+1))	return true;
		}
		arr[r][c] = 0;
		return false;
	}
	static boolean check(int r,int c) {
		int[] num = new int[9];
		Arrays.fill(num,0);
		for(int i = 0;i < N*N;i++)
			if(arr[i][c] != 0 && ++num[arr[i][c] - 1] > 1)
				return false;
		Arrays.fill(num,0);
		for(int i = 0;i < N*N;i++)
			if(arr[r][i] != 0 && ++num[arr[r][i] - 1] > 1)
				return false;
		r /= N; c /= N;
		Arrays.fill(num,0);
		for(int i = 0;i < N;i++) for(int j = 0;j < N;j++)
			if(arr[i + r*N][j + c*N] != 0 && ++num[arr[i + r*N][j + c*N] - 1] > 1)
				return false;
		return true;
	}
}
