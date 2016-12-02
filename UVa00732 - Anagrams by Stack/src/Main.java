import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		while(in.ready()) {
			do {s1 = in.readLine().toCharArray();} while(s1.length == 0);
			do {s2 = in.readLine().toCharArray();} while(s2.length == 0);
			idx = 0;
			out.write("[\n");
			if(s1.length == s2.length)	run(0,0,"");
			out.write("]\n");
		}
		out.flush();
	}
	static BufferedWriter out;
	static int idx;
	static char[] stack = new char[500];
	static char[] s1,s2;
	static void run(int p1,int p2,String output) throws Exception {
		if(idx == 0 && output.length() == s1.length * 4) {
			out.write(output.substring(1) + "\n");
			return;
		}
		if(p1 < s1.length) {
			stack[idx++] = s1[p1];
			run(p1 + 1,p2,output + " i");
			idx--;
		}
		if(idx > 0 && stack[idx-1] == s2[p2] && p2 < s2.length) {
			char t = stack[--idx];
			run(p1,p2 + 1,output + " o");
			stack[idx++] = t;
		}
	}
}
