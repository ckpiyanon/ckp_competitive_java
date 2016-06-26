public class Main {
	static boolean graph[][] = new boolean[6][6];
	static void dfs(int u,String path,int nodes) {
		if(nodes == 8) {
			System.out.println(path);
			return;
		}
		nodes++;
		for(int i = 1;i <= 5;i++) if(graph[u][i]) {
			graph[u][i] = graph[i][u] = false;
			dfs(i,path + i,nodes);
			graph[u][i] = graph[i][u] = true;
		}
	}
	public static void main(String args[]) throws Exception {
		int[][] arr = {
			{0,0,0,0,0,0},{0,0,1,1,0,1},{0,1,0,1,0,1},
			{0,1,1,0,1,1},{0,0,0,1,0,1},{0,1,1,1,1,0}};
		for(int i = 1;i <= 5;i++) for(int j = 1;j <= 5;j++)
			graph[i][j] = arr[i][j] == 1;
		dfs(1,"1",0);
	}
}
