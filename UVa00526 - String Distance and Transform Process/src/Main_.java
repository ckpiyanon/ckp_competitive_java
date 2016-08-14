import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_ {
	static int cnt,insert,delete,arr[][];
	static char s1[],s2[];
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int l1,l2,TC = Integer.parseInt(in.readLine());
		arr = new int[2001][2001];
		while(TC-- > 0) {
			l1 = (s1 = in.readLine().toCharArray()).length;
			l2 = (s2 = in.readLine().toCharArray()).length;
			for(int i = 0;i <= l1;i++)	arr[i][0] = i;
			for(int i = 0;i <= l2;i++)	arr[0][i] = i;
			for(int i = 1;i <= l1;i++) for(int j = 1;j <= l2;j++)
				arr[i][j] = s1[i-1] == s2[j-1] ? arr[i-1][j-1]:(Math.min(arr[i-1][j-1],Math.min(arr[i][j-1],arr[i-1][j])) + 1);
			cnt = insert = delete = 0;
			System.out.println(arr[l1][l2]);
		}
	}
}
