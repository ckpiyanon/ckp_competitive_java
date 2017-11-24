import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static final int SIZE = 9;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt();
		int[][] arr = new int[SIZE][];
		for(int i = 0;i < SIZE;i++)	arr[i] = new int[i+1];
		while(TC-- > 0) {
			for(int i = 0;i < SIZE;i += 2) for(int j = 0;j <= i;j += 2)
				arr[i][j] = getInt();
			for(int i = SIZE - 1;i > 0;i -= 2)	for(int j = 2;j < arr[i].length;j += 2) {
				arr[i][j-1] = (arr[i-2][j-2] - arr[i][j-2] - arr[i][j]) / 2;
				arr[i-1][j-2] = arr[i][j-2] + arr[i][j-1];
				arr[i-1][j-1] = arr[i][j] + arr[i][j-1];
			}
			for(int[] each:arr)	System.out.println(Arrays.toString(each).replace("[","").replace("]","").replace(",",""));
		}
	}
}
