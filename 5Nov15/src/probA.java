import java.io.BufferedReader;
import java.io.InputStreamReader;

public class probA {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
int n,width;
		int[] fib = new int[30];
		StringBuilder sb;
		fib[0] = 0;
		fib[1] = fib[2] = 1;
		for(int i = 3;i < 30;i++)	fib[i] = fib[i-1] + fib[i-2];
		while(true) {
			n = Integer.parseInt(in.readLine());
			if(n == -1)	break;
			width = n - 1 + fib[n];
			for(int i = 1;i <= n;i++) {
				sb = new StringBuilder();
				for(int x = 1;x <= width;x++) {
					if(x + 1 <= i)
						sb.append('.');
					else if(x >= i && x < i + fib[i])
						sb.append('#');
					else
						sb.append('.');
				}
				System.out.println(sb.toString() + sb.reverse());
				sb.reverse();
				System.out.println(sb.toString() + sb.reverse());
			}
			System.out.println();
		}
	}
}
