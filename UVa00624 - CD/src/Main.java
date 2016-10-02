import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			int maxLength = (int)st.nval;
			int size = getInt();
			for(int i = 0;i < size;i++)	list[i] = getInt();
			dp = new int[size + 1][maxLength + 1];
			for(int i = 0;i <= size;i++) for(int j = 0;j <= maxLength;j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(j < list[i-1])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j],list[i-1] + dp[i-1][j - list[i-1]]);
			}
			trace(size,maxLength);
			System.out.println("sum:" + dp[size][maxLength]);
		}
	}
	static int[][] dp;
	static int list[] = new int[20];
	static void trace(int i,int j) {
		if(i == 0 || j == 0)	return;
		else if(j < list[i-1] || dp[i-1][j] > list[i-1] + dp[i-1][j - list[i-1]])	trace(i-1,j);
		else {
			trace(i-1,j - list[i-1]);
			System.out.print(list[i-1] + " ");
		}
	}
}
