import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = {1,-1,0,0},dc[] = {0,0,1,-1},arr[][] = new int[100][100],n,cont;
	static void play(int r,int c) {
		int nr,nc,t;
		t = arr[r][c];
		arr[r][c] = -1;
		cont++;
		for(int i = 0;i < 4;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] != t)	continue;
			play(nr,nc);
		}
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String ans[] = {"good\n","wrong\n"};
		boolean ansI;
		while(true) {
			n = Integer.parseInt(in.readLine());
			if(n == 0)	break;
			for(int[] a: arr)	Arrays.fill(a,0);
			for(int i = 1;i < n;i++) {
				st = new StringTokenizer(in.readLine());
				while(st.hasMoreTokens())
					arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i;
			}
			ansI = true;
			for(int i = 0;i < n && ansI;i++)
				for(int j = 0;j < n && ansI;j++) {
					if(arr[i][j] != -1) {
						cont = 0;
						play(i,j);
						if(cont != n) {
							ansI = false;
							break;
						}
					}
				}
			bfw.write(ansI ? ans[0]:ans[1]);
		}
		bfw.flush();
	}
}
