import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	StreamTokenizer st;
	double getNum() throws Exception {
		st.nextToken();
		return st.nval;
	}
	int getInt() throws Exception {return (int)getNum();}
	long getLong() throws Exception {return (long)getNum();}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		new Main().run();
	}
	void run() throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		long arr[][][] = new long[21][21][21],max;
		int TC = getInt(),A,B,C;
		while(TC-- > 0) {
			A = getInt();
			B = getInt();
			C = getInt();
			for(int i = 0;i < 21;i++)
				for(int j = 0;j < 21;j++)
					Arrays.fill(arr[i][j],0);
			for(int i = 1;i <= A;i++) for(int j = 1;j <= B;j++) for(int k = 1;k <= C;k++)
				arr[i][j][k] = getLong();
			for(int i = 0;i <= A;i++)
				for(int j = 0;j <= B;j++)
					for(int k = 1;k <= C;k++)
						arr[i][j][k] += arr[i][j][k-1];
			for(int i = 0;i <= A;i++)
				for(int j = 0;j <= B;j++)
					for(int k = 1;k <= C;k++)
						arr[i][k][j] += arr[i][k-1][j];
			for(int i = 0;i <= A;i++)
				for(int j = 0;j <= B;j++)
					for(int k = 1;k <= C;k++)
						arr[k][i][j] += arr[k-1][i][j];
			max = Long.MIN_VALUE;
			for(int x1 = 0;x1 < A;x1++) for(int x2 = x1 + 1;x2 <= A;x2++)
			for(int y1 = 0;y1 < B;y1++) for(int y2 = y1 + 1;y2 <= B;y2++)
			for(int z1 = 0;z1 < C;z1++) for(int z2 = z1 + 1;z2 <= C;z2++) {
				long tmp = arr[x2][y2][z2];
				tmp -= 
				max = Math.max(max,
						arr[x2][y2][z2] - arr[x2][y1][z1] + arr[x2][y1][z2] + arr[x2][y2][z1]
						- (arr[x1][y2][z2] - arr[x1][y1][z1] + arr[x1][y1][z2] + arr[x1][y2][z1])
						);
			}
			System.out.println(max);
			if(TC > 0)	System.out.println();
		}
	}
}
