import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Main {
	static BufferedWriter out;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s,t;
		int TC = Integer.parseInt(in.readLine());
		boolean first = true;
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		while(TC-- > 0) {
			if(!first)	out.write("\n");
			first = false;
			s = in.readLine(); t = in.readLine();
			dfs(s,t); trace(t);
		}
		out.flush();
	}
	static Map<String,String> parent = new TreeMap<String,String>();
	static Map<String,Boolean> visited = new TreeMap<String,Boolean>();
	static void trace(String t) throws Exception {
		if(t == null)	return;
		trace(parent.get(t));
		out.write(t); out.write("\n");
	}
	static void dfs(String s,String t) {
	}
	static String morph(String s,int p) {
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(p,map[s.charAt(p) - 'a'][s.charAt(p+1) - 'a']);
		return sb.deleteCharAt(p+1).toString();
	}
	static char[][] map = {{'b','b','a'},{'c','b','a'},{'a','c','c'}};
}
