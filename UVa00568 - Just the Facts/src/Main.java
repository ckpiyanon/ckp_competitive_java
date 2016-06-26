import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int cut(int n) {
		while(n % 10 == 0)	n /= 10;
		return n;
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10001];
		int n;
		arr[0] = 1;
		for(int i = 1;i <= 10000;i++)	arr[i] = cut(cut(i) * arr[i-1]) % 100000;
		while(in.ready()) {
			n = Integer.parseInt(in.readLine());
			System.out.printf("%5d -> %d\n",n,arr[n] % 10);
		}
	}
}
