import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main_BF {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream(new File("in.txt")));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int a,b,c,max = 0,min = 2000000000;
		int arr[] = new int[10001];
		while(st.nextToken() != -1) {
			a = (int)st.nval;
			st.nextToken();
			b = (int)st.nval;
			st.nextToken();
			c = (int)st.nval;
			min = Math.min(min,a);
			max = Math.max(max,c);
			for(int i = a;i < c;i++)
				arr[i] = Math.max(arr[i],b);
		}
		for(int i = min;i <= max;i++)
			if(arr[i] != arr[i-1]) {
				out.write(String.valueOf(i));
				out.write(" ");
				out.write(String.valueOf(arr[i]));
				if(i < max)	out.write(" ");
			}
		out.write("\n");
		out.flush();
	}
}
