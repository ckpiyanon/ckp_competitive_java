import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] tbl = new boolean[100][100];
	static boolean[][] arr = new boolean[100][100];
	static int numRow,numCol;
	static int dr[] = {-1,-1,-1, 1, 1, 1, 0, 0};
	static int dc[] = {-1, 0, 1,-1, 0, 1,-1, 1};
	static int play(int r,int c) {
		if(r < 0 || c < 0 || r >= numRow || c >= numCol || !arr[r][c])
			return 0;
		int n = 1;
		arr[r][c] = false;
		for(int i = 0;i < 8;i++) {
			n += play(r + dr[i],c + dc[i]);
		}
		return n;
	}
	public static void main(String[] args) throws IOException {
		try {
			System.setIn(new FileInputStream("in.txt"));
		} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		StringTokenizer st;
		int TC = Integer.parseInt(in.readLine());
		int k;
		in.readLine();
		while(TC-- > 0) {
			k = 0;
			s = in.readLine().toUpperCase();
			numCol = s.length();
			while(!Character.isDigit(s.charAt(0))) {
				for(int i = 0;i < numCol;i++)
					tbl[k][i] = s.charAt(i) == 'W';
				s = in.readLine().toUpperCase();
				k++;
			}
			numRow = k;
			while(s != null && !s.equals("")) {
				for(int i = 0;i < numRow;i++) for(int j = 0;j < numCol;j++) arr[i][j] = tbl[i][j];
				st = new StringTokenizer(s);
				out.write(play(Integer.parseInt(st.nextToken()) - 1,Integer.parseInt(st.nextToken()) - 1) + "\n");
				s = in.readLine();
			}
			if(TC > 0)
				out.write("\n");
		}
		out.flush();
		out.close();
		in.close();
	}
}
