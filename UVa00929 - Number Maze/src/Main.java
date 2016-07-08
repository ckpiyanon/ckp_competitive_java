import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static int N,M;
	static int[][] arr;
	public static void main(String args[]) throws Exception {
		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){};
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		arr = new int[1000][1000];
		int TC = getInt();
		while(TC-- > 0) {
			N = getInt(); M = getInt();
			for(int i = 0;i < N;i++) for(int j = 0;j < M;j++)
				arr[i][j] = getInt();
			System.out.println(dijkstra());
		}
	}
	static int dr[] = {0,0,-1,1},dc[] = {-1,1,0,0};
	static int dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean[][] visited = new boolean[N][M];
		int nr,nc;
		pq.add(new Edge(0,0,arr[0][0]));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.r][e.c])	continue;
			visited[e.r][e.c] = true;
			if(e.r == N-1 && e.c == M-1)	return e.w;
			for(int i = 0;i < 4;i++) {
				nr = e.r + dr[i]; nc = e.c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])	continue;
				pq.add(new Edge(nr,nc,arr[nr][nc] + e.w));
			}
		}
		return 0;
	}
	static class Edge implements Comparable<Edge> {
		public int r,c,w;
		public Edge(int r,int c,int w) {
			this.r = r; this.c = c; this.w = w;
		}
		public int compareTo(Edge e) {
			return Integer.compare(this.w,e.w);
		}
		public String toString() {
			return "(" + r + "," + c + "," + w + ")";
		}
	}
}
