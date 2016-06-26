import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class probB {
	public static void main(String args[]) throws Exception {
		new probB().run();
	}
	final int M = 100009;
	char s[];
	int arr[];
	int find(int pos) {
		if(arr[pos] != 0)	return arr[pos];
		int ans = 1;
		for(int i = pos + 1;i < s.length;i++) {
			if(s[pos] != s[i])	ans += find(i);
			ans %= M;
		}
		return arr[pos] = ans;
	}
	void run() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		int ans = 1;
		arr = new int[1001];
		for(int TC_ = 1;TC_ <= TC;TC_++) {
			s = in.readLine().toCharArray();
			Arrays.fill(arr,0);
			for(int i = 0;i < s.length;i++)
				ans = (ans + find(i)) % M;
			System.out.println("Case " + TC_ + ": " + ans % M);
		}
	}
}
