import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int[] sieve() {
		boolean[] isPrime = new boolean[1000];
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.fill(isPrime,true);
		list.add(1);
		for(int i = 2;i < 1000;i++) if(isPrime[i]) {
			for(int j = i+i;j < 1000;j += i)	isPrime[j] = false;
			list.add(i);
		}
		int[] arr = new int[list.size()];
		for(int i = 0;i < list.size();i++)
			arr[i] = list.get(i);
		return arr;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N,C,x,mid,from,to;
		int[] prime = sieve();
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			N = (int)st.nval;
			st.nextToken(); C = (int)st.nval;
			x = 0;
			from = 0; to = prime.length; mid = to / 2;
			while(prime[mid] != N && from < to - 1) {
				if(N > prime[mid]) from = mid;
				else to = mid;
				mid = (from + to) / 2;
			}
			x = mid + 1;
			mid = x / 2;
			from = Math.max(0,x % 2 == 1 ? (mid - C + 1):(mid - C));
			to = Math.min(x,mid + C);
			out.write(N + " " + C + ": ");
			out.write(Arrays.toString(Arrays.copyOfRange(prime,from,to)).replaceAll("[^ 0-9]",""));
			out.write("\n\n");
		}
		out.flush();
		out.close();
	}
}
