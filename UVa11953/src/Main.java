import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int dr[] = {0,0,1,-1},dc[] = {1,-1,0,0};
	static char arr[][];
	static int N;
	static void floodfill(int r,int c) {
		arr[r][c] = '.';
		for(int i = 0;i < 4;i++) {
			int nr = r + dr[i],nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] == '.')	continue;
			floodfill(nr,nc);
		}
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine()),ans;
		arr = new char[100][];
		for(int tc = 1;tc <= TC;tc++) {
			ans = 0;
			N = Integer.parseInt(in.readLine());
			for(int i = 0;i < N;i++)	arr[i] = in.readLine().toCharArray();
			for(int i = 0;i < N;i++) for(int j = 0;j < N;j++) if(arr[i][j] == 'x') {
				floodfill(i,j);
				ans++;
			}
			System.out.println("Case " + tc + ": " + ans);
		}
	}
}
