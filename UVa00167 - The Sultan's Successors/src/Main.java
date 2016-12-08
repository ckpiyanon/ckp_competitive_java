import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt();
		while(TC-- > 0) {
			for(int i = 0;i < 8;i++) for(int j = 0;j < 8;j++) {arr[i][j] = getInt(); placed[i][j] = false;}
			ans = 0; place(0,8,0);
			System.out.printf("%5d\n",ans);
		}
	}
	static int ans;
	static int[] dr = {-1,-1,1,1},dc = {-1,1,-1,1};
	static int[][] arr = new int[8][8];
	static boolean[][] placed = new boolean[8][8];
	static void place(int pos,int num,int sum) {
		if(num == 0)	ans = Math.max(ans,sum);
		for(int i = pos;i < 64;i++) if(check(i)) {
			placed[i / 8][i % 8] = true;
			place(i + 1,num - 1,sum + arr[i / 8][i % 8]);
			placed[i / 8][i % 8] = false;
		}
	}
	static boolean check(int pos) {
		int r = pos / 8,c = pos % 8;
		for(int i = 0;i < 4;i++) {
			for(int nr = r + dr[i],nc = c + dc[i];nr >= 0 && nr < 8 && nc >= 0 && nc < 8;nr += dr[i],nc += dc[i])
				if(placed[nr][nc])	return false;
		}
		return true;
	}
}
