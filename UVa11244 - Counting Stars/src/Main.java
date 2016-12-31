import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int num;
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(R == 0 && C == 0)	break;
			num = 0;
			for(int i = 0;i < R;i++) 	grid[i] = in.readLine().toCharArray();
			for(int i = 0;i < R;i++) for(int j = 0;j < C;j++)
				if(grid[i][j] == '*') {
					if(floodfill(i,j) == 1)	num++;
				}
			out.write(num + "\n");
		}
		out.flush();
	}
	static char[][] grid = new char[101][];
	static int R,C;
	static int[] dr = {-1,-1,-1,0,0,1,1,1},dc = {-1,0,1,-1,1,-1,0,1};
	static int floodfill(int r,int c) {
		grid[r][c] = '.';
		int ret = 1;
		for(int i = 0;i < 8;i++) {
			int nr = r + dr[i],nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C || grid[nr][nc] != '*')	continue;
			ret += floodfill(nr,nc);
		}
		return ret;
	}
}
