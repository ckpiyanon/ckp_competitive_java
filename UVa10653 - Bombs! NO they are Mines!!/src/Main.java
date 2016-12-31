import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		while((R = getInt()) != 0 & (C = getInt()) != 0) {
			for(int i = 0;i < R;i++) for(int j = 0;j < C;j++)
				graph[i][j] = 0;
			n = getInt();
			while(n-- > 0) {
				int r = getInt(),m = getInt();
				while(m-- > 0)	graph[r][getInt()] = 2;
			}
			out.write(bfs(getInt(),getInt(),getInt(),getInt()) + "\n");
		}
		out.flush();
	}
	static int R,C;
	static int[][] graph = new int[1000][1000];
	static int[] dr = {-1,0,1,0},dc = {0,-1,0,1};
	static int bfs(int sr,int sc,int tr,int tc) {
		Queue<Edge> q = new LinkedList<Edge>();
		q.add(new Edge(sr,sc,0));
		graph[sr][sc] = 1;
		while(!q.isEmpty()) {
			Edge e = q.poll();
			if(e.r == tr && e.c == tc)	return e.w;
			graph[e.r][e.c] = 2;
			for(int i = 0;i < 4;i++) {
				int nr = e.r + dr[i],nc = e.c + dc[i];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C || graph[nr][nc] != 0)	continue;
				graph[nr][nc] = 1;
				q.add(new Edge(nr,nc,e.w + 1));
			}
		}
		return 0;
	}
	static class Edge {
		int r,c,w;
		Edge(int rr,int cc,int ww) {r = rr; c = cc; w = ww;}
	}
}
