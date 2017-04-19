import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] m = new long[50],f = new long[50];
		int n;
		m[1] = 1;
		for(int i = 2;i < 50;i++) {
			m[i] = 1 + m[i-1] + f[i-1];
			f[i] = m[i-1];
		}
		while((n = Integer.parseInt(in.readLine())) != -1)	out.write(m[n] + " " + (m[n] + f[n] + 1) + "\n");
		out.flush();
	}
}
