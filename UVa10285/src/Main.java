import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int m,n,arr[][],mic[][];
	static int dr[] = {0,0,1,-1},dc[] = {-1,1,0,0};
	static String getS() throws Exception {
		st.nextToken();
		return st.sval;
	}
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),ans;
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		arr = new int[100][100];
		mic = new int[100][100];
		while(TC-- > 0) {
			s = getS();
			m = getInt();
			n = getInt();
			for(int i = 0;i < m;i++)	for(int j = 0;j < n;j++)	arr[i][j] = getInt();
			for(int i = 0;i < m;i++)	Arrays.fill(mic[i],0,n,0);
			for(int i = 0;i < m;i++)
				for(int j = 0;j < n;j++)
					if(mic[i][j] == 0)
						play(i,j);
			ans = 0;
			for(int i = 0;i < m;i++)
				for(int j = 0;j < n;j++)
					ans = Math.max(ans,mic[i][j]);
			out.write(s);
			out.write(": ");
			out.write(String.valueOf(ans));
			out.write("\n");
		}
		out.flush();
	}
	static int play(int r,int c) {
		if(mic[r][c] != 0)	return mic[r][c];
		int nr,nc,ans = 0;
		for(int i = 0;i < 4;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr < 0 || nr >= m || nc < 0 || nc >= n)	continue;
			if(arr[r][c] < arr[nr][nc])
				ans = Math.max(ans,play(nr,nc));
		}
		mic[r][c] = ans + 1;
		return mic[r][c];
	}
}
