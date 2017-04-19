import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<Integer>();
		int TC = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0)	break;
			list.clear();
			for(int i = 0;i < H;i++)	Arrays.fill(visited[i],false);
			for(int i = 0;i < H;i++)	grid[i] = in.readLine().toCharArray();
			for(int i = 0;i < H;i++) for(int j = 0;j < W;j++)
				if(grid[i][j] != '.' && !visited[i][j]) {
					dl.clear();
					floodfill(i,j);
					int n = 0;
					for(Pair p:dl) if(grid[p.r][p.c] == 'X') {
						n++; floodx(p.r,p.c);
					}
					list.add(n);
				}
			Collections.sort(list);
			out.write("Throw " + ++TC + "\n");
			for(int i = 0;i < list.size();i++)
				out.write(list.get(i) + (i < list.size() - 1 ? " ":"\n"));
			out.write("\n");
		}
		out.flush();
	}
	static int W,H;
	static char[][] grid = new char[50][];
	static boolean[][] visited = new boolean[50][50];
	static int[] dr = {0,0,-1,1},dc = {-1,1,0,0};
	static ArrayList<Pair> dl = new ArrayList<Pair>();
	static void floodfill(int r,int c) {
		dl.add(new Pair(r,c));
		for(int i = 0;i < 4;i++) {
			int nr = r + dr[i],nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= H || nc >= W || grid[nr][nc] == '.' || visited[nr][nc])	continue;
			visited[nr][nc] = true;
			floodfill(nr,nc);
		}
	}
	static void floodx(int r,int c) {
		grid[r][c] = '.';
		for(int i = 0;i < 4;i++) {
			int nr = r + dr[i],nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= H || nc >= W || grid[nr][nc] != 'X')	continue;
			floodx(nr,nc);
		}
	}
	static class Pair {
		int r,c;
		Pair(int rr,int cc) {r = rr; c = cc;}
	}
}
