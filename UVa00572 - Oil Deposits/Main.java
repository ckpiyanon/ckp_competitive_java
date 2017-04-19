import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int dr[] = {0,0,1,-1,1,1,-1,-1};
	static int dc[] = {1,-1,0,0,1,-1,1,-1};
	static int m,n;
	static void fill(int r,int c) {
		if(r < 0 || r >= m || c < 0 || c >= n || map[r][c] != '@')	return;
		map[r][c] = '*';
		for(int i = 0;i < 8;i++)	fill(r + dr[i],c + dc[i]);
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st;
		map = new char[100][];
		int ans;
		while(true) {
			s = in.readLine();
			if(s.equals("0 0"))	break;
			st = new StringTokenizer(s);
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			for(int i = 0;i < m;i++)	map[i] = in.readLine().toCharArray();
			ans = 0;
			for(int i = 0;i < m;i++) for(int j = 0;j < n;j++) if(map[i][j] == '@') {
				ans++; fill(i,j);
			}
			System.out.println(ans);
		}
	}
}
