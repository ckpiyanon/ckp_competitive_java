import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		int TC = Integer.parseInt(in.readLine()),ans;
		in.readLine();
		while(TC-- > 0) {
			R = 0;
			while((s = in.readLine()) != null && s.length() > 0)
				grid[R++] = s.toCharArray();
			C = grid[0].length;
			ans = 0;
			for(int i = 0;i < R;i++) for(int j = 0;j < C;j++)
				if(grid[i][j] == '1')	ans = Math.max(ans,floodfill(i,j));
			out.write(ans + "\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
	static int R,C;
	static char[][] grid = new char[25][];
	static int[] dr = {-1,-1,-1,0,0,1,1,1},dc = {-1,0,1,-1,1,-1,0,1};
	static int floodfill(int r,int c) {
		grid[r][c] = '0';
		int ret = 1;
		for(int i = 0;i < 8;i++) {
			r += dr[i]; c += dc[i];
			if(r > -1 && c > -1 && r < R && c < C && grid[r][c] == '1')
				ret += floodfill(r,c);
			r -= dr[i]; c -= dc[i];
		}
		return ret;
	}
}
