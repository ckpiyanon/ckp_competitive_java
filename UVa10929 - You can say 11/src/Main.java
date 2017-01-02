import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		while(!(s = in.readLine()).equals("0")) {
			int sum = 0;
			for(int i = 0;i < s.length();i++) {
				if(i % 2 == 0)	sum += s.charAt(i) - '0';
				else	sum -= s.charAt(i) - '0';
			}
			out.write(s + " is" + (sum % 11 == 0 ? "":" not") + " a multiple of 11.\n");
		}
		out.flush();
	}
}
