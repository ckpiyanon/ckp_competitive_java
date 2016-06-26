import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static char arr[][];
	static boolean v[][];
	static int dr[] = { 0, 0,-1, 1,-1,-1, 1, 1};
	static int dc[] = {-1, 1, 0, 0,-1, 1,-1, 1};
	static StreamTokenizer st;
	
	static int getInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	static String getString() throws IOException {
		st.nextToken();
		return st.sval;
	}
	static int getS(int n) {
		if(n == 3 || n == 4)
			return 1;
		if(n == 5)
			return 2;
		if(n == 6)
			return 3;
		if(n == 7)
			return 5;
		if(n > 7)
			return 11;
		return 0;
	}
	static boolean play(int r,int c,char s[],int n) {
		if(arr[r][c] != s[n])
			return false;
		if(n == s.length-1)
			return true;
		v[r][c] = true;
		int nr,nc;
		for(int i = 0;i < 8;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || v[nr][nc])
				continue;
			if(play(nr,nc,s,n+1))
				return true;
		}
		v[r][c] = false;
		return false;
	}
	public static void main(String [] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		arr = new char[4][];
		v = new boolean[4][4];
		String s;
		int q,nw,cnt = 0,ans;
		q = getInt();
		while(q-- > 0) {
			for(int i = 0;i < 4;i++) {
				s = getString();
				arr[i] = s.toCharArray();
			}
			nw = getInt();
			ans = 0;
			for(int h = 0;h < nw;h++) {
				for(int i = 0;i < 4;i++)
					for(int j = 0;j < 4;j++)
						v[i][j] = false;
				s = getString();
				for(int i = 0;i < 4;i++) {
					for(int j = 0;j < 4;j++) {
						if(play(i,j,s.toCharArray(),0)) {
							ans += getS(s.length());
							j = 5; i = 5;
						}
					}
				}
			}
			out.write("Score for Boggle game #" + (++cnt) + ": " + ans + "\n");
		}
		out.flush();
		out.close();
	}
}
