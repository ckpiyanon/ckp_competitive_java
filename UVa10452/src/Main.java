import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static ArrayList<String> ans = new ArrayList<String>();
	static int dr[] = {-1, 0, 0};
	static int dc[] = { 0, 1,-1};
	static char str[] = {'@','I','E','H','O','V','A','#'};
	static int rows,cols;
	static char arr[][] = new char[10][];
	static String path[] = {"forth","left","right"};
	
	static void play(int r,int c,int n) {
		int nr,nc;
		if(arr[r][c] == '#')	return;
		for(int i = 0;i < 3;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && arr[nr][nc] == str[n+1]) {
				if(dr[i] == -1)			ans.add("forth");
				else if(dc[i] == -1)	ans.add("left");
				else if(dc[i] == 1)		ans.add("right");
				play(nr,nc,n+1);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		try {System.setIn(new FileInputStream(new File("in.txt")));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String tmp[];
		int q;
		q = Integer.parseInt(in.readLine());
		while(q-- > 0) {
			ans.clear();
			tmp = in.readLine().split(" ");
			rows = Integer.parseInt(tmp[0]);
			cols = Integer.parseInt(tmp[1]);
			for(int i = 0;i < rows;i++)	arr[i] = in.readLine().toCharArray();
			for(int i = 0;i < rows;i++) {
				for(int j = 0;j < cols;j++) {
					if(arr[i][j] == '@') {
						play(i,j,0);
						j = cols + 1;
						i = rows + 1;
					}
				}
			}
			for(int i = 0;i < ans.size();i++) {
				out.write(ans.get(i));
				if(i < ans.size() - 1)
					out.write(" ");
			}
			out.write("\n");
		}
		out.flush();
		out.close();
	}
}
