import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StreamTokenizer;

public class ProbL {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("Linput.txt"));} catch(Exception e) {}
		try {System.setOut(new PrintStream("Lans.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),arr[] = new int[3],min;
		while(TC-- > 0) {
			for(int i = 0;i < 3;i++)	arr[i] += getInt();
			min = Math.min(arr[0],Math.min(arr[1],arr[2]));
			if(min < 30)	System.out.println("NO");
			else {
				System.out.println(min);
				for(int i = 0;i < 3;i++)	arr[i] -= min;
			}
		}
	}
}
