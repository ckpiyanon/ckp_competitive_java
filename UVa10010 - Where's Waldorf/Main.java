import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer tok = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static int getInt() throws IOException {
		tok.nextToken();
		return (int)tok.nval;
	}
	static String getString() throws IOException {
		tok.nextToken();
		return tok.sval;
	}
	static int[] dirx = { 0, 0, 1,-1, 1, 1,-1,-1};
	static int[] diry = { 1,-1, 0, 0, 1,-1, 1,-1};
	static int[] play(char[] s,char[][] arr) {
		for(int i = 0;i < s.length;i++)
			s[i] = Character.toUpperCase(s[i]);
		int[] ans = new int[2];
		boolean found = false;
		for(int i = 0;i < arr.length && !found;i++) {
			for(int j = 0;j < arr[0].length && !found;j++) {
				if(arr[i][j] == s[0]) {
					for(int k = 0;k < 8 && !found;k++) {
						for(int l = 0;l < s.length && !found;l++) {
							if(i + l*dirx[k] < 0 || i + l*dirx[k] >= arr.length || j + l*diry[k] < 0 || j + l*diry[k] >= arr[0].length)
								break;
							if(arr[i + l*dirx[k]][j + l*diry[k]] != s[l])
								break;
							if(l == s.length - 1) {
								found = true;
							}
						}
						if(found) {
							ans[0] = i+1;
							ans[1] = j+1;
						}
					}
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] arr;
		int[] ans;
		int n,q;
		int x,y;
		q = getInt();
		while(q-- > 0) {
			x = getInt();
			y = getInt();
			arr = new char[x][y];
			for(int i = 0;i < x;i++) {
				arr[i] = getString().toCharArray();
			}
			for(int i = 0;i < x;i++)
				for(int j = 0;j < y;j++)
					arr[i][j] = Character.toUpperCase(arr[i][j]);
			n = getInt();
			for(int i = 0;i < n;i++) {
				ans = play(getString().toCharArray(),arr);
				out.write(ans[0] + " " + ans[1] + "\n");
			}
			if(q > 0)
				out.write("\n");
		}
		out.flush();
		out.close();
	}
}

