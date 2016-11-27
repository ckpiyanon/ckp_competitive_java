import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream(new File("in.txt")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[][] = new int[1001][1001];
		char[] s1,s2;
		while(in.ready()) {
			s1 = in.readLine().toCharArray();
			s2 = in.readLine().toCharArray();
			for(int i = 1;i <= s1.length;i++)	for(int j = 1;j <= s2.length;j++)
				arr[i][j] = ((s1[i-1] == s2[j-1]) ? (1 + arr[i-1][j-1]):Math.max(arr[i-1][j],arr[i][j-1]));
			out.write(String.valueOf(arr[s1.length][s2.length]));
			out.write('\n');
		}
		out.flush();
	}
}
