import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> set = new ArrayList<Integer>();
		String s;
		int TC = Integer.parseInt(in.readLine()),n;
		while(TC-- > 0) {
			s = in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			set.clear();
			while(n-- > 0)	set.add(Integer.valueOf(st.nextToken()));
			out.write(s + " - " + (check(s,set) ? "Wonderful.\n":"Simple.\n"));
		}
		out.flush();
	}
	static boolean check(String m,List<Integer> list) {
		for(Integer n:list)	if(!divisible(m,n))	return false;
		return true;
	}
	static boolean divisible(String m,int n) {
		int rem = 0;
		for(int i = 0;i < m.length();i++)
			rem = (rem * 10 + m.charAt(i) - '0') % n;
		return rem == 0;
	}
}
