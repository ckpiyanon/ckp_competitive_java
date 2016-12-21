import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt(),n;
		byte[] ans = new byte[1000000];
		while(TC-- > 0) {
			n = getInt();
			for(int i = 0;i < n;i++)	ans[i] = (byte)(getInt() + getInt());
			for(int i = n-1;i >= 0;i--) if(ans[i] >= 10 && i > 0) {
				ans[i] -= 10; ans[i-1]++;
			}
			if(ans[0] >= 10) {out.write('1'); ans[0] -= 10;}
			for(int i = 0;i < n;i++)	out.write(ans[i] + '0');
			out.write("\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
}
