import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int a,b,c,d,l,cnt;
		while((a = getInt()) != 0 | (b = getInt()) != 0 | (c = getInt()) != 0 | (d = getInt()) != 0 | (l = getInt()) != 0) {
			cnt = 0;
			for(int i = 0;i <= l;i++) if((a * i * i + b * i + c) % d == 0)
				cnt++;
			out.write(cnt + "\n");
		}
		out.flush();
	}
}
