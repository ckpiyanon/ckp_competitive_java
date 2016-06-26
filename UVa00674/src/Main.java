import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int arr[] = {1,5,10,25,50};
	static int dp[];
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[8000]; dp[0] = 1;
		for(int i = 0;i < 5;i++)
			for(int j = arr[i];j < 8000;j++)
				dp[j] += dp[j - arr[i]];
		while(in.ready())
			System.out.println(dp[Integer.parseInt(in.readLine())]);
	}
}
