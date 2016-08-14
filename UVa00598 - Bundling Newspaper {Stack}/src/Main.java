import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter out;
	static String list[];
	static int numS;
	static void play(int n) throws Exception {
		if(n == 1) {
			for(int i = 0;i < numS;i++)	out.write(list[i] + "\n");
			return;
		}
		Stack<String> stack = new Stack<String>();
		for(int start = 0,index = 0;start <= numS - n;index = ++start) {
			stack.clear();
			stack.push(list[index++]);
			while(!stack.isEmpty() && index < numS) {
			}
		}
	}
	public static void main(String[] args) throws Exception {
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
			while((inS = in.readLine()) != null && inS.length() > 0)	list[numS++] = inS;
			if(st.countTokens() == 2) {
				m = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				for(int i = m;i <= n;i++) {
					out.write("Size " + i + "\n");
					play(i);
					out.write("\n");
				}
			}
			else {
				inS = st.nextToken();
				if(inS.charAt(0) == '*')
					for(int i = 1;i <= numS;i++) {
						out.write("Size " + i + "\n");
						play(i);
						out.write("\n");
					}
				else {
					n = Integer.parseInt(inS);
					out.write("Size " + n + "\n");
					play(n);
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
