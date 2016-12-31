import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s;
		while(!(s = in.readLine()).equals("0 0 0")) {
			st = new StringTokenizer(s);
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			for(int i = 0;i < L;i++)
			{
				for(int j = 0;j < R;j++)
					grid[i][j] = in.readLine().toCharArray();
				in.readLine();
			}
			boolean found = false;
			for(int i = 0;i < L && !found;i++) for(int j = 0;j < R && !found;j++) for(int k = 0;k < C && !found;k++)
				if(grid[i][j][k] == 'S') {
					int ans = bfs(i,j,k);
					out.write(ans != -1 ? "Escaped in " + ans + " minute(s).\n":"Trapped!\n");
					found = true;
				}
		}
		out.flush();
	}
	static int L,R,C;
	static int[][][] dist = new int[30][30][30];
	static char[][][] grid = new char[30][30][];
	static int[] dl = {-1,1,0,0,0,0},dr = {0,0,-1,1,0,0},dc = {0,0,0,0,-1,1};
	static int bfs(int l,int r,int c) {
		Queue<Edge> q = new LinkedList<Edge>();
		for(int i = 0;i < L;i++) for(int j = 0;j < R;j++) for(int k = 0;k < C;k++)
			dist[i][j][k] = -1;
		q.add(new Edge(l,r,c));
		dist[l][r][c] = 0;
		while(!q.isEmpty()) {
			Edge e = q.poll();
			for(int i = 0;i < 6;i++) {
				int nl = e.l + dl[i],nr = e.r + dr[i],nc = e.c + dc[i];
				if(nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C || grid[nl][nr][nc] == '#' || dist[nl][nr][nc] != -1)
					continue;
				dist[nl][nr][nc] = dist[e.l][e.r][e.c] + 1;
				if(grid[nl][nr][nc] == 'E')	return dist[nl][nr][nc];
				q.add(new Edge(nl,nr,nc));
			}
		}
		return -1;
	}
	static class Edge {
		int l,r,c;
		Edge(int ll,int rr,int cc) {l = ll; r = rr; c = cc;}
	}
}
