import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ProbK {
	static String SPLITTER = "";
	static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	public static void main(String args[]) throws Exception {
		long time = System.currentTimeMillis();
		try {System.setIn(new FileInputStream("inK.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new PrintStream(new File("outK.txt"))));
		ArrayList<Node> list = new ArrayList<Node>(100000);
		for(char ch = 'a';ch <= 'z';ch++)	if(ch != 'a' && ch != 'e' && ch != 'i' & ch != 'o' && ch != 'u')
			SPLITTER += ch;
		int TC = getInt(),n;
		while(TC-- > 0) {
			list.clear();
			n = getInt();
			while(n-- > 0)	list.add(new Node(getString()));
			Collections.sort(list);
			out.write(list.toString().replace("[","").replace("]","\n").replace(",",""));
		}
		out.flush();
		System.out.println(System.currentTimeMillis() - time);
	}
	static class Node implements Comparable<Node> {
		String s;
		int n;
		public Node(String s) {
			this.s = s;
			n = new StringTokenizer(s,SPLITTER).countTokens();
		}
		public int compareTo(Node node) {
			return n == node.n ? s.compareTo(node.s):Integer.compare(node.n,n);
		}
		public String toString() {return s;}
	}
}
