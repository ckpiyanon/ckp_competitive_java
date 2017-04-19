import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static int[] dx = {-1,-1, 1, 1};
	static int[] dy = { 1,-1, 1,-1};
	static int px,py;
	static int play(int k,int x,int y) {
		if(k == 0 || x < 0 || y < 0 || x > 2048 || y > 2048)	return 0;
		int ans = 0;
		if(x + k >= px && x - k <= px && y + k >= py && y - k <= py)	ans++;
		for(int i = 0;i < 4;i++)	ans += play(k / 2,x + dx[i]*k,y + dy[i]*k);
		return ans;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int k;
		while((k = getInt()) != 0 & (px = getInt()) != 0 & (py = getInt()) != 0) {
			System.out.printf("%3d\n",play(k,1024,1024));
		}
	}
}
