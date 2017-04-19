import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int x[] = new int[2];
	static int y[] = new int[2];
	static int dr[] = {1, 1,-1,-1, 1, 0, 0};
	static int dc[] = {1,-1, 1,-1, 0, 1,-1};
	static int n;
	static char[][] arr;
	static boolean find(char[] s,int r,int c) {
		int len = s.length;
		int nr,nc;
		for(int k = 0;k < 7;k++) {
			for(int i = 0;i < len;i++) {
				nr = r + dr[k]*i;
				nc = c + dc[k]*i;
				if(nr < 0 || nc < 0 || nr >= n || nc >= n || s[i] != arr[nr][nc])	break;
				if(i == len-1) {
					x[0] = r+1; y[0] = c+1;
					x[1] = nr+1; y[1] = nc+1;
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new char[100][];
		char toFind[];
		for(int i = 0;i < n;i++)	arr[i] = in.readLine().toCharArray();
		while((toFind = in.readLine().toCharArray())[0] != '0') {
			boolean found = false;
			for(int i = 0;i < n && !found;i++) for(int j = 0;j < n && !found;j++) {
				if(find(toFind,i,j)) {
					found = true;
					System.out.println(x[0] + "," + y[0] + " " + x[1] + "," + y[1]);
				}
			}
			if(!found)	System.out.println("Not found");
		}
	}
}
