import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		while((s = in.readLine()).charAt(0) != '-') {
			if(s.length() > 1 && s.charAt(1) == 'x')
				out.write(Integer.toString(Integer.parseInt(s.substring(2),16)) + "\n");
			else
				out.write("0x" + Integer.toHexString(Integer.parseInt(s)).toUpperCase() + "\n");
		}
		out.flush();
	}
}
