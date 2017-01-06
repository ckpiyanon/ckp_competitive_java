import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0)	out.write(((long)Math.floor(Math.sqrt(8*Long.parseLong(in.readLine()) + 1)) - 1) / 2 + "\n");
		out.flush();
	}
}
