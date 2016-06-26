import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Character> list = new LinkedList<Character>();
		char[] inp;
		int TC = Integer.parseInt(in.readLine()),len,t;
		long fact[] = new long[21],n;
		fact[0] = 1;
		for(int i = 1;i < 21;i++)	fact[i] = i * fact[i-1];
		while(TC-- > 0) {
			list.clear();
			len = (inp = in.readLine().toCharArray()).length;
			Arrays.sort(inp);
			n = Long.parseLong(in.readLine());
			for(int i = 0;i < len;i++)	list.add(inp[i]);
			for(int i = 0;i < len;i++) {
				t = (int)(n / fact[list.size() - 1]);
				inp[i] = list.get(t);
				list.remove(t);
				n %= fact[list.size()];
			}
			out.write(inp,0,len);
			out.write("\n");
		}
		out.flush();
	}
}
