import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static String pre,in;
	static void play(int pre0,int pre1,int in0,int in1) {
		char ch = pre.charAt(pre0);
		int x = in.indexOf(ch);
		int y = pre0 + x - in0;
		if(y > pre0)	play(pre0 + 1,y,in0,x - 1);
		if(y < pre1)	play(y + 1,pre1,x + 1,in1);
		System.out.print(ch);
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != -1) {
			pre = st.sval; st.nextToken(); in = st.sval;
			play(0,pre.length() - 1,0,in.length() - 1);
			System.out.println();
		}
	}
}
