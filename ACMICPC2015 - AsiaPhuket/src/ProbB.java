import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProbB {
	static int[] arr;
	static long sum(int idx) {
		long ans = 0;
		for(int i = 0;i < idx;i++)	for(int j = 0;j <= i;j++)
			ans += arr[j];
		return ans;
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("Binput.txt"));} catch(Exception e) {}
		try {System.setOut(new PrintStream("Bans.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		for(int x = 1;x <= TC;x++) {
			int N,L,total,idx;
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i = 0;i < N;i++)	arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			idx = 0;
			total = 0;
			while(idx < N && total + arr[idx] <= L)
				total += arr[idx++];
			System.out.printf("Case %d: %d %d %d\n",x,idx,total,sum(idx));
		}
	}
}
