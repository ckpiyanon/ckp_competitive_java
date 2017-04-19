import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		String s;
		int len;
		boolean first = true;
		while(true) {
			sb = new StringBuilder();
			len = 0;
			while((s = in.readLine()) != null && s.length() > 0) {
				for(char ch:s.toCharArray()) {
					if(Character.isDigit(ch))	len += ch - '0';
					else if(ch == '!')	sb.append('\n');
					else {
						for(int i = 0;i < len;i++)	sb.append(ch == 'b' ? ' ':ch);
						len = 0;
					}
				}
				if(sb.charAt(sb.length() - 1) != '\n')	sb.append('\n');
			}
			out.write((!first ? "\n":"") + sb.toString());
			first = false;
			if(s == null)	break;
		}
		out.flush();
	}
}
