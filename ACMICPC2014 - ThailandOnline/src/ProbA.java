import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProbA {
	static int[] arr;
	static boolean[] prime;
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10000001];
		prime = new boolean[10000001];
		Arrays.fill(prime,true);
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		for(int i = 2;i <= 10000000;i++)	if(prime[i])
			for(int j = i + i;j <= 10000000;j += i)	prime[j] = false;
		for(int i = 3;i <= 10000000;i++)	arr[i] = prime[i] ? (1 + arr[i-2]):(1 + arr[i-1]); 
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0)	System.out.println(arr[Integer.parseInt(in.readLine())]);
	}
}
