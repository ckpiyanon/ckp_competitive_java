import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new InputStreamReader(System.in));
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			N = (int)st.nval; M = getInt();
			for(int i = 0;i < N;i++) for(int j = 0;j < M;j++)
				arr[i][j] = getInt();
			for(int c = M - 2;c >= 0;c--) for(int r = 0;r < N;r++)
				arr[r][c] += Math.min(arr[r][c+1],Math.min(arr[f(r-1)][c+1],arr[f(r+1)][c+1]));
			int pos = 0,ans = arr[0][0];
			for(int i = 1;i < N;i++) if(ans > arr[i][0]) {pos = i; ans = arr[i][0];}
			for(int i = 0;i < M;i++) {
				out.write((i == 0 ? "":" ") + (pos + 1));
				int p1 = f(pos-1),p2 = pos,p3 = f(pos+1);
				if(p1 > p2) {p1 ^= p2; p2 ^= p1; p1 ^= p2;}
				if(p2 > p3) {p2 ^= p3; p3 ^= p2; p2 ^= p3;}
				if(p1 > p2) {p1 ^= p2; p2 ^= p1; p1 ^= p2;}
				int sum = Math.min(arr[p1][i+1],Math.min(arr[p2][i+1],arr[p3][i+1]));
				if(sum == arr[p1][i+1])	pos = p1;
				else if(sum == arr[p2][i+1])	pos = p2;
				else	pos = p3;
			}
			out.write("\n" + ans + "\n");
		}
		out.flush();
	}
	static int N,M,arr[][] = new int[11][101];
	static int f(int n) {return n < 0 ? n + N:(n >= N ? n - N:n);}
}
