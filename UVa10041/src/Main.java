import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt(),n,arr[] = new int[500],t,ans;
		while(TC-- > 0) {
			n = getInt();
			for(int i = 0;i < n;i++)	arr[i] = getInt();
			Arrays.sort(arr,0,n);
			ans = 0;
			t = arr[n/2];
			for(int i = 0;i < n;i++)	ans += Math.abs(t - arr[i]);
			out.write(String.valueOf(ans));
			out.write("\n");
		}
		out.flush();
	}
}
