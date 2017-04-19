import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[][] s = new char[2][];
		int arr[][];
		while(in.ready()) {
			s[0] = in.readLine().toCharArray();
			s[1] = in.readLine().toCharArray();
			arr = new int[2][26];
			for(int i = 0;i < 2;i++) for(char c:s[i])
				arr[i][c - 'a']++;
			for(int i = 0;i < 26;i++) for(int j = 0;j < Math.min(arr[0][i],arr[1][i]);j++)
				System.out.print((char)(i + 'a'));
			System.out.println();
		}
	}
}
