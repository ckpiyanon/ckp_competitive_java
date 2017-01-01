import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,TC = 0;
		int[] arr = new int[5];
		while((n = getInt()) != 0) {
			Arrays.fill(arr,0);
			for(int i = 0;i < n;i++) for(int j = 0;j < n;j++)	arr[Math.min(Math.min(i,j),Math.min(n-i-1,n-j-1))] += getInt();
			if(n % 2 == 1)	n++;
			n /= 2;
			out.write("Case " + ++TC + ":");
			for(int i = 0;i < n;i++) out.write(" " + arr[i]);
			out.write("\n");
		}
		out.flush();
	}
}
