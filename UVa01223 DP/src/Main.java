import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC,len,max,arr[][] = new int[5001][5001];
		char s[];
		TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			len = (s = in.readLine().toCharArray()).length;
			max = 0;
			for(int i = 1;i <= len;i++)
				for(int j = 1;j <= len;j++) {
					if(s[i-1] == s[j-1] && i != j)
						max = Math.max(max,arr[i][j] = arr[i-1][j-1] + 1);
					else	arr[i][j] = 0;
				}
			out.write(String.valueOf(max));
			out.write("\n");
		}
		out.flush();
	}
}
