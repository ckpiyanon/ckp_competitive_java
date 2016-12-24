import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		while((s = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			String ans = Long.toString(Long.parseLong(st.nextToken(),Integer.parseInt(st.nextToken())),Integer.parseInt(st.nextToken())).toUpperCase();
			out.write(String.format("%7s\n",ans.length() > 7 ? "ERROR":ans));
		}
		out.flush();
	}
}
