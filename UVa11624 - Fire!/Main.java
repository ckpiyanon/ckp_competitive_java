import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		arr = new char[1000][];
		fire = new LinkedList<Cell>(); joe = new LinkedList<Cell>(); q = new LinkedList<Cell>();
		while(TC-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			fire.clear(); joe.clear(); q.clear();
			for(int i = 0;i < n;i++) {
				arr[i] = Arrays.copyOf(in.readLine().toCharArray(),m);
				for(int j = 0;j < m;j++) {
					char ch = arr[i][j];
					switch(ch) {
					case 'J': joe.add(new Cell(i,j)); break;
					case 'F': fire.add(new Cell(i,j)); break;
					}
				}
			}
			int ans = bfs();
			out.write(ans == -1 ? ("IMPOSSIBLE\n"):(ans + "\n"));
		}
		out.flush();
	}
	static Queue<Cell> fire,joe,q;
	static char[][] arr;
	static int n,m;
	static int[] dr = {-1,1,0,0},dc = {0,0,-1,1};
	static int bfs() {
		int steps = 1;
		Queue<Cell> t;
		while(!joe.isEmpty()) {
			while(!fire.isEmpty()) {
				Cell p = fire.poll();
				for(int i = 0;i < 4;i++) {
					int nr = p.r + dr[i],nc = p.c + dc[i];
					if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] == '#' || arr[nr][nc] == 'F') continue;
					arr[nr][nc] = 'F';
					q.add(new Cell(nr,nc));
				}
			}
			t = fire; fire = q; q = t;
			while(!joe.isEmpty()) {
				Cell p = joe.poll();
				for(int i = 0;i < 4;i++) {
					int nr = p.r + dr[i],nc = p.c + dc[i];
					if(nr < 0 | nc < 0 || nr >= n || nc >= m)	return steps;
					if(arr[nr][nc] != '.')	continue;
					arr[nr][nc] = 'J';
					q.add(new Cell(nr,nc));
				}
			}
			t = joe; joe = q; q = t;
			steps++;
		}
		return -1;
	}
	static class Cell {
		public int r,c;
		public Cell(int r,int c) {this.r = r; this.c = c;}
	}
}
