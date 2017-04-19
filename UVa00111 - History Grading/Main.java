import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N = getInt();
		int[] arr = new int[20],list = new int[20];
		int[][] map = new int[21][21];
		for(int i = 0;i < N;i++)	arr[getInt() - 1] = i;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			list[(int)st.nval - 1] = 0;
			for(int i = 1;i < N;i++)	list[getInt() - 1] = i;
			for(int i = 1;i <= N;i++) for(int j = 1;j <= N;j++) {
				map[i][j] = (list[i-1] == arr[j-1]) ? (map[i-1][j-1] + 1):Math.max(map[i][j-1],map[i-1][j]);
			}
			System.out.println(map[N][N]);
		}
	}
}
