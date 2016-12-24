import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String fs,ss;
		int TC = Integer.parseInt(in.readLine()),f,s;
		char opr;
		while(TC-- > 0) {
			st = new StringTokenizer(in.readLine());
			f = Integer.parseInt(st.nextToken(),16);
			opr = st.nextToken().charAt(0);
			s = Integer.parseInt(st.nextToken(),16);
			fs = Integer.toBinaryString(f); ss = Integer.toBinaryString(s);
			write(out,fs); out.write(" " + opr + " "); write(out,ss); out.write(" = " + (opr == '+' ? f + s:f - s) + "\n");
		}
		out.flush();
	}
	static void write(Writer o,String s) throws Exception {
		for(int i = 0;i < 13 - s.length();i++)	o.write('0');
		o.write(s);
	}
}
