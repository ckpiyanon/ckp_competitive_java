import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb1,sb2;
		int ans,car;
		while(true) {
			sb1 = new StringBuilder();
			sb2 = new StringBuilder();
			sb1.append(getInt());
			sb2.append(getInt());
			if(sb1.toString().equals("0") && sb2.toString().equals("0"))
				break;
			while(sb1.length() < sb2.length())	sb1.insert(0,0);
			while(sb2.length() < sb1.length())	sb2.insert(0,0);
			ans = car = 0;
			for(int i = sb1.length() - 1;i >= 0;i--) {
				if(sb1.charAt(i) + sb2.charAt(i) - '0' - '0' + car >= 10) {
					car = 1;
					ans++;
				}
				else	car = 0;
			}
			out.write(ans == 0 ? "No":String.valueOf(ans));
			out.write(" carry operation");
			out.write(ans > 1 ? "s.\n":".\n");
		}
		out.flush();
		out.close();
	}
}
