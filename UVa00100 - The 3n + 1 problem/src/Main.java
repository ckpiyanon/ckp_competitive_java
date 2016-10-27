import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static int arr[] = new int[15000000];
	public static void main(String args[]) throws Exception {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int m,n;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			m = (int)st.nval;
			st.nextToken();
			n = (int)st.nval;
			out.write(m + " " + n + " " + findMax(m,n) + "\n");
		}
		out.flush();
	}
	static int findMax(int a,int b) {
		int max = 0;
		for(int i = Math.min(a,b);i <= Math.max(a,b);i++)	max = Math.max(max,play(i));
		return max;
	}
	static int play(int n) {
		if(n < 15000000 && arr[n] > 0)	return arr[n];
		if(n == 1)	return 1;
		int ans = 1 + play(n % 2 == 0 ? (n/2):(3*n + 1));
		if(n < 15000000)	arr[n] = ans;
		return ans;
	}
}
