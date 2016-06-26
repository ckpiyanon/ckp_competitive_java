import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] s1 = "1234567890-=WERTYUIOP[]\\SDFGHJKL;'XCVBNM,./".toCharArray();
		char[] s2 = "`1234567890-QWERTYUIOP[]ASDFGHJKL;ZXCVBNM,.".toCharArray();
		char map[] = new char[256];
		for(int i = 0;i < s1.length;i++)	map[s1[i]] = s2[i];
		String inS;
		while((inS = in.readLine()) != null) {
			for(int i = 0;i < inS.length();i++) {
				if(map[inS.charAt(i)] != '\0')	out.write(map[inS.charAt(i)]);
				else	out.write(inS.charAt(i));
			}
			out.write('\n');
		}
		out.flush();
	}

}
