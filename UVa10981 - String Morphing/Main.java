import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	static BufferedWriter out;
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s,t;
		int TC = Integer.parseInt(in.readLine());
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		while(TC-- > 0) {
			parent.clear();
			s = in.readLine(); t = in.readLine();
			if(dfs(s,t))	trace(t);
			else	out.write("None exist!\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
	static Map<String,String> parent = new TreeMap<String,String>();
	static void trace(String t) throws Exception {
		if(t == null)	return;
		trace(parent.get(t));
		out.write(t); out.write("\n");
	}
	static boolean dfs(String s,String t) throws Exception {
		if(s.length() == t.length())	return s.equals(t);
		for(int i = 1;i < s.length();i++) {
			String u = morph(s,i-1);
			if(parent.containsKey(u))	continue;
			parent.put(u,s);
			if(dfs(u,t))	return true;
		}
		return false;
	}
	static String morph(String s,int p) {
		StringBuilder sb = new StringBuilder(s.substring(0,p));
		sb.append(map[s.charAt(p) - 'a'][s.charAt(p+1) - 'a']);
		return sb.append(s.substring(p+2)).toString();
	}
	static final char[][] map = {{'b','b','a'},{'c','b','a'},{'a','c','c'}};
}
