import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int ans,numCycle,TC = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
			if(n == 0 || m == 0)	break;
			maxR = n*3; maxC = m*3;
			for(int r = 0;r < n;r++) {
				char[] s = in.readLine().toCharArray();
				for(int c = 0;c < m;c++) for(int i = 0;i < 3;i++) for(int j = 0;j < 3;j++)
					grid[r*3 + i][c*3 + j] = (s[c] == '\\' && i == j) || (s[c] == '/' && i + j == 2) ? '*':' ';
			}
			ans = numCycle = 0;
			for(int i = 0;i < Math.max(maxR,maxC);i++) {
				if(i < maxR) {floodfill(i,0,' ','*'); floodfill(i,maxC - 1,' ','*');}
				if(i < maxC) {floodfill(0,i,' ','*'); floodfill(maxR - 1,i,' ','*');}
			}
			for(int i = 1;i < maxR - 1;i++) for(int j = 1;j < maxC - 1;j++) if(grid[i][j] == ' ') {
				ans = Math.max(ans,floodfill(i,j,' ','-'));
				numCycle++;
			}
			System.out.println("Maze #" + ++TC + ":");
			if(numCycle == 0)	System.out.println("There are no cycles.");
			else	System.out.println(numCycle + " Cycles; the longest has length " + (ans / 3) + ".");
			System.out.println();
		}
	}
	static int n,m;
	static int maxR,maxC;
	static char grid[][] = new char[300][300];
	static int[] dr = {-1,1,0,0},dc = {0,0,-1,1};
	static int floodfill(int r,int c,char from,char to) {
		if(r < 0 || r >= maxR || c < 0 || c >= maxC || grid[r][c] != from)	return 0;
		int num = 1;
		grid[r][c] = to;
		for(int i = 0;i < 4;i++) {
			int nr = r + dr[i],nc = c + dc[i];
			num += floodfill(nr,nc,from,to);
		}
		return num;
	}
}
