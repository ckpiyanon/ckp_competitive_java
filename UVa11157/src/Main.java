import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static String gets() throws Exception {
		st.nextToken();
		return st.sval;
	}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stt;
		char bs;
		int TC = getInt(),cases = 1,dist,nst,t,ans,sz,arr[] = new int[200];
		while(TC-- > 0) {
			sz = 0;
			nst = getInt();
			dist = getInt();
			arr[sz++] = 0;
			arr[sz++] = 0;
			for(int i = 0;i < nst;i++) {
				stt = new StringTokenizer(gets(),"-");
				bs = stt.nextToken().charAt(0);
				arr[sz++] = (t = Integer.parseInt(stt.nextToken()));
				if(bs == 'B')	arr[sz++] = t;
			}
			arr[sz++] = dist;
			arr[sz++] = dist;
			ans = -2000000000;
			for(int i = 2;i < sz;i++)
				ans = Math.max(ans,arr[i] - arr[i - 2]);
			out.write("Case ");
			out.write(String.valueOf(cases++));
			out.write(": ");
			out.write(String.valueOf(ans));
			out.write("\n");
		}
		out.flush();
	}
}