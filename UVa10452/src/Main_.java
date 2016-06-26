import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Main_ {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("in.txt")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StreamTokenizer(in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC,m,n,s1 = 0,s2 = 0,dr[] = {0,0,-1},dc[] = {-1,1,0},nr,nc;
		char arr[][] = new char[10][10],ans[] = {'I','E','H','O','V','A','#'};
		String path[] = {"left","right","forth"};
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			for(int i = 0;i < n;i++) arr[i] = in.readLine().toCharArray();
			for(int i = 0;i < n;i++) for(int j = 0;j < m;j++) if(arr[i][j] == '@') {s1 = i;s2 = j;i = n;break;}
			for(int x = 0;x < 7;x++) {
				for(int i = 0;i < 3;i++) {
					nr = s1 + dr[i];
					nc = s2 + dc[i];
					if(nr >= n || nr < 0 || nc >= m || nc < 0)	continue;
					if(arr[s1 + dr[i]][s2 + dc[i]] == ans[x]) {
						sb.append(path[i]);
						s1 = nr;s2 = nc;
					}
				}
				if(x < 6)	sb.append(' ');
			}
			sb.append('\n');
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

}
