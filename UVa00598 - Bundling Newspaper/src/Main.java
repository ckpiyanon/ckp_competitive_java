import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter out;
	static String list[];
	static int numS;
	static void play(int n,String seq,int next) throws Exception {
		if(n == 0)	out.write(seq + "\n");
		for(int i = next;i < numS;i++)
			play(n-1,seq.length() == 0 ? list[i]:(seq + ", " + list[i]),i+1);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("in.txt")));
		System.setOut(new PrintStream(new File("out.txt")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String inS;
		int TC = Integer.parseInt(in.readLine()),m,n;
		list = new String[12];
		in.readLine();
		while(TC-- > 0) {
			st = new StringTokenizer(in.readLine());
			numS = 0;
			while((inS = in.readLine()) != null && inS.length() > 0)
				list[numS++] = inS;
			if(st.countTokens() == 2) {
				m = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				for(int i = m;i <= n;i++) {
					out.write("Size " + i + "\n");
					play(i,"",0);
					out.write("\n");
				}
			}
			else {
				inS = st.nextToken();
				if(inS.charAt(0) == '*') {
					for(int i = 1;i <= numS;i++) {
						out.write("Size " + i + "\n");
						play(i,"",0);
						out.write("\n");
					}
				}
				else {
					n = Integer.parseInt(inS);
					out.write("Size " + n + "\n");
					play(n,"",0);
					out.write("\n");
				}
			}
			if(TC > 0)
				out.write("\n");
		}
		out.flush();
		in.close();
		out.close();
	}
}
