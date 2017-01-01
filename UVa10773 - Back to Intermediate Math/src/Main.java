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
		int TC = getInt();
		double d,v,u;
		for(int i = 1;i <= TC;i++) {
			d = getNum(); v = getNum(); u = getNum();
			out.write("Case " + i + ": ");
			if(u <= v || u < 1e-9 ||  v < 1e-9)	out.write("can't determine\n");
			else	out.write(df.format(d / Math.sqrt(u*u - v*v) - d / u) + "\n");
		}
		out.flush();
	}
}
