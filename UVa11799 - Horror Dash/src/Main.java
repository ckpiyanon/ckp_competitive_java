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
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1;tc <= TC;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int ans = 0;
			while(st.hasMoreTokens())	ans = Math.max(ans,Integer.parseInt(st.nextToken()));
			out.write("Case " + tc + ": " + ans + "\n");
		}
		out.flush();
	}
}
