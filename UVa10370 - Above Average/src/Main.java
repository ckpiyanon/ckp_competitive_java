import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;

public class Main {
	static StreamTokenizer st;
	static double getNum() throws Exception {st.nextToken(); return st.nval;}
	static int getInt() throws Exception {return (int)getNum();}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		DecimalFormat df = new DecimalFormat("0.000");
		int TC = getInt(),n;
		double avg,ans;
		double[] arr = new double[1000];
		while(TC-- > 0) {
			ans = avg = 0; n = getInt();
			for(int i = 0;i < n;i++)	avg += (arr[i] = getNum());
			avg /= n;
			for(int i = 0;i < n;i++) if(arr[i] > avg) ans += 1;
			out.write(df.format(ans * 100.0 / n) + "%\n");
		}
		out.flush();
	}
}
