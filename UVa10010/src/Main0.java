import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main0 {
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
		try {
			System.setIn(new FileInputStream(new File("in.txt")));
		} catch(FileNotFoundException e) {}
		BufferedInputStream in = new BufferedInputStream(System.in);
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		StringTokenizer tok;
		String sin;
		char[][] arr;
		int[] ans;
		byte[] bin = new byte[1000000],bout;
		int n,q,nin;
		int x,y;
		nin = in.read(bin);
		sin = new String(bin,0,nin);
		tok = new StringTokenizer(sin);
		q = Integer.parseInt(tok.nextToken());
		while(q-- > 0) {
			x = Integer.parseInt(tok.nextToken());
			y = Integer.parseInt(tok.nextToken());
			arr = new char[x][y];
			for(int i = 0;i < x;i++) {
				arr[i] = tok.nextToken().toCharArray();
			}
			for(int i = 0;i < x;i++)
				for(int j = 0;j < y;j++)
					arr[i][j] = Character.toUpperCase(arr[i][j]);
			n = Integer.parseInt(tok.nextToken());
			for(int i = 0;i < n;i++) {
				ans = play(tok.nextToken().toCharArray(),arr);
				bout = new String(ans[0] + " " + ans[1] + "\n").getBytes();
				out.write(bout);
			}
			if(q > 0)
				out.write(new String("\n").getBytes());
		}
		out.flush();
		out.close();
		in.close();
	}
}