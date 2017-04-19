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
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,max,sum,x;
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while((n = getInt()) != 0) {
			max = sum = 0;
			while(n-- > 0) {
				x = getInt();
				if(sum + x < 0)	sum = 0;
				else	sum += x;
				max = Math.max(max,sum);
			}
			out.write(max > 0 ? "The maximum winning streak is " + max + ".\n":"Losing streak.\n");
		}
		out.flush();
	}
}
