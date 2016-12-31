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
		int TC = getInt(),arr[] = new int[5];
		boolean yes;
		while(TC-- > 0) {
			for(int i = 0;i < 5;i++)	arr[i] = getInt();
			yes = true;
			for(int i = 1;i < 5 && yes;i++)
				if(arr[i] - 1 != arr[i-1])
					yes = false;
			out.write(yes ? "Y\n":"N\n");
		}
		out.flush();
	}
}
