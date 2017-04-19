import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static final int MOD = 20437;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = 0,sumLen,ans;
		int[] cR = new int[26],cC = new int[26];
		char maxTarget;
		while((N = Integer.parseInt(in.readLine())) != 0) {
			maxTarget = 'A';
			ans = 1; sumLen = 0;
			for(int i = 0;i < N;i++)	arr[i] = in.readLine().toCharArray();
			for(int i = 0;i < N;i++) for(int j = 0;j < N;j++)
				if(Character.isAlphabetic(arr[i][j])) {
					cR[arr[i][j] - 'A'] = i;
					cC[arr[i][j] - 'A'] = j;
					if(arr[i][j] > maxTarget)	maxTarget = arr[i][j];
				}
			for(char ch = 'A';ch < maxTarget && ans > 0;ch++) {
				int p = ch - 'A';
				int maxLen = bfs(cR[p],cC[p],cR[p+1],cC[p+1]);
				if(maxLen != -1) {
					ans = (ans * dfs(cR[p],cC[p],cR[p+1],cC[p+1],0,maxLen)) % MOD;
					sumLen += maxLen;
				}
				else	ans = 0;
			}
			out.write(String.format("Case %d: %s\n",++tc,ans > 0 ? String.format("%d %d",sumLen,ans):"Impossible"));
		}
		out.flush();
		in.close(); out.close();
	}
	static int N;
	static int[] visited = new int[10];
	static char[][] arr = new char[10][];
	static int bfs(int sR,int sC,int tR,int tC) {
		Queue<Coord> q = new LinkedList<Coord>();
		Coord n;
		Arrays.fill(visited,0);
		q.add(new Coord(sR,sC,0));
		visited[sR] = setTrue(visited[sR],sC);
		while(!q.isEmpty()) {
			n = q.poll();
			int uR = n.getR(),uC = n.getC(),uW = n.getW();
			if(uR == tR && uC == tC)	return uW;
			for(int i = 0;i < 4;i++) {
				int vR = uR + dr[i],vC = uC + dc[i];
				if(vR < 0 || vC < 0 || vR >= N || vC >= N || arr[vR][vC] == '#' ||
						Character.isAlphabetic(arr[vR][vC]) && arr[vR][vC] > arr[tR][tC] ||
						isTrue(visited[vR],vC))
					continue;
				visited[vR] = setTrue(visited[vR],vC);
				q.add(new Coord(vR,vC,uW + 1));
			}
		}
		return -1;
	}
	static int dfs(int sR,int sC,int tR,int tC,int len,int maxLen) {
		if(sR == tR && sC == tC || len == maxLen)
			return sR == tR && sC == tC && len == maxLen ? 1:0;
		int ans = 0;
		for(int i = 0;i < 4;i++) {
			int vR = sR + dr[i],vC = sC + dc[i];
			if(vR < 0 || vC < 0 || vR >= N || vC >= N || arr[vR][vC] == '#' ||
					Character.isAlphabetic(arr[vR][vC]) && arr[vR][vC] > arr[tR][tC])
				continue;
			char tmp = arr[sR][sC];
			arr[sR][sC] = '#';
			ans += dfs(vR,vC,tR,tC,len + 1,maxLen);
			arr[sR][sC] = tmp;
		}
		return ans;
	}
	static final int dr[] = {-1,0,1,0},dc[] = {0,-1,0,1};
	static int setTrue(int bits,int idx) {return bits |= (1 << idx);}
	static int setFalse(int bits,int idx) {return bits &= ~(1 << idx);}
	static boolean isTrue(int bits,int idx) {return ((bits >> idx) & 1) == 1;}
	static class Coord {
		private int r,c,w;
		public Coord(int rr,int cc,int ww) {r = rr; c = cc; w = ww;}
		public int getR() {return r;}
		public int getC() {return c;}
		public int getW() {return w;}
	}
}
