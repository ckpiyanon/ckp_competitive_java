import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StreamTokenizer;

public class ProbI {
	static StreamTokenizer st;
	static double getNum() throws Exception {
		st.nextToken();
		return st.nval;
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("Iinput.txt"));} catch(Exception e) {}
		try {System.setOut(new PrintStream("Ians.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = (int)getNum();
		double r,v;
		for(int x = 1;x <= TC;x++) {
			r = getNum(); v = getNum();
			System.out.printf("Case %d: %.8f\n",x,r*Math.PI/v/2);
		}
	}
}
