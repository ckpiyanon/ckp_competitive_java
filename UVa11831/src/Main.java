import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int N,M,S,r,c;
	static char arr[][],order[],dd[],de[],dir;
	static int getInt() {
		return Integer.parseInt(st.nextToken());
	}
	static int play() {
		int ans = 0,dr = 0,dc = 0,nr,nc;
		for(int i = 0;i < order.length;i++) {
//			System.out.println("Position: " + "(" + r + "," + c + ")");
			switch(dir) {
			case 'N': dr = -1; dc = 0; break;
			case 'S': dr = 1; dc = 0; break;
			case 'L': dr = 0; dc = 1; break;
			case 'O': dr = 0; dc = -1; break;
			}
			if(order[i] == 'F') {
				nr = r + dr;
				nc = c + dc;
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == '#')
					continue;
				if(arr[nr][nc] == '*') {
					ans++;
					arr[nr][nc] = '.';
				}
				r = nr; c = nc;
			}
			else {
				switch(order[i]) {
				case 'D': dir = dd[dir]; break;
				case 'E': dir = de[dir]; break;
				}
			}
		}
		return ans;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		dd = new char[256];
		de = new char[256];
		dd['N'] = 'L'; dd['L'] = 'S'; dd['S'] = 'O'; dd['O'] = 'N';
		de['N'] = 'O'; de['O'] = 'S'; de['S'] = 'L'; de['L'] = 'N';
		arr = new char[100][];
		while(true) {
			st = new StringTokenizer(in.readLine());
			N = getInt(); M = getInt(); S = getInt();
			if(N == 0 && M == 0 && S == 0)	break;
			r = c = -1;
			for(int i = 0;i < N;i++) {
				arr[i] = in.readLine().toCharArray();
				for(int j = 0;j < M && r == -1 && c == -1;j++)
					if(Character.isAlphabetic(arr[i][j])) {
						r = i; c = j;
						dir = arr[i][j];	// N - North; S - South; L - East; O - West
					}
			}
			order = in.readLine().toCharArray();
			System.out.println(play());
		}
	}
}
