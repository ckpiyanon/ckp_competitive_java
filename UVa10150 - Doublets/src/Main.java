import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> set;
	static Map<String,String> parent;
	static boolean bfs(String src,String tar) {
		Queue<Pair> q = new LinkedList<Pair>();
		Pair e;
		StringBuilder sb;
		String s,s_;
		parent.clear();
		q.add(new Pair(src,src));
		while(!q.isEmpty()) {
			e = q.poll();
			if(parent.containsKey(e.first))
				continue;
			parent.put(e.first,e.second);
			if(e.first.equals(tar)) return true;
			s = e.first;
			for(int i = 0;i < s.length();i++) {
				sb = new StringBuilder(s);
				for(char c = 'a';c <= 'z';c++) {
					if(c == s.charAt(i)) continue;
					sb.setCharAt(i,c);
					s_ = sb.toString();
					if(set.contains(s_) && !parent.containsKey(s_))
						q.add(new Pair(s_,s));
				}
			}
		}
		return false;
	}
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static void printAns(String src,String tar) throws Exception {
		if(src.equals(tar)) {
			out.write(src);
			out.write('\n');
			return;
		}
		String s = parent.get(tar);
		printAns(src,s);
		out.write(tar);
		out.write('\n');
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s,src,tar;
		boolean first = true;
		set = new HashSet<String>();
		parent = new HashMap<String,String>();
		while((s = in.readLine()).length() > 0)	set.add(s);
		while((s = in.readLine()) != null) {
			st = new StringTokenizer(s);
			if(!first)	out.write("\n");
			first = false;
			if(bfs(src = st.nextToken(),tar = st.nextToken()))
				printAns(src,tar);
			else	out.write("No solution.\n");
		}
		out.flush();
	}
	static class Pair {
		public String first,second;
		public Pair(String first,String second) {this.first = first; this.second = second;}
	}
}
