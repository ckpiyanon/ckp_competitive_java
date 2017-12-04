import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		new Main().run();
	}
	StreamTokenizer st; BufferedReader in; BufferedWriter out;
	void setIO() throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StreamTokenizer(in);
	}
	String getS() throws Exception {st.nextToken(); return st.sval;}
	double getNum() throws Exception {st.nextToken(); return st.nval;}
	int getInt() throws Exception {return (int)getNum();}
	void run() throws Exception {setIO(); sol();}
	void sol() throws Exception {
		int[] s = new int[3];
		while(true) {
			for(int i = 0;i < 3;i++)	s[i] = getInt();
			if(s[0] == 0 && s[1] == 0 && s[2] == 0) break;
			Arrays.sort(s);
			out.write(s[0]*s[0] + s[1]*s[1] == s[2]*s[2] ? "right\n":"wrong\n");
		}
		out.flush();
	}
}