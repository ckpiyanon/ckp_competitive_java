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
		int TC = getInt(),tc = 0,n,h,l,arr[] = new int[50];
		while(TC-- > 0) {
			n = getInt();
			for(int i = 0;i < n;i++)	arr[i] = getInt();
			h = l = 0;
			for(int i = 1;i < n;i++) {
				if(arr[i] > arr[i-1])	h++;
				else if(arr[i] < arr[i-1])	l++;
			}
			out.write("Case " + ++tc + ": " + h + " " + l + "\n");
		}
		out.flush();
	}
}
