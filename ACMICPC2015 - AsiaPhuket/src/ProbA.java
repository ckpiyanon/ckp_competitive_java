import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ProbA {
	static String _S = "0123456789ABCDEF";
	static int hextoint(char[] inp,int pos) {
		return _S.indexOf(inp[pos])*16 + _S.indexOf(inp[pos+1]);
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("Ainput.txt"));} catch(Exception e) {}
		try {System.setOut(new PrintStream("Aans.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char inp[];
		while(in.ready()) {
			inp = in.readLine().toCharArray();
			for(int i = 0;i < inp.length;i += 2)
				System.out.print((char)hextoint(inp,i));
			System.out.println();
		}
	}
}
