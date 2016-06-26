import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<String> list = new ArrayList<String>(100);
	static void play(char[] rule,int idx,String out) {
		if(idx >= rule.length) {
			System.out.println(out);
			return;
		}
		if(rule[idx] == '#') for(String s:list)	play(rule,idx + 1,out + s);
		else for(int i = 0;i < 10;i++) play(rule,idx + 1,out + i);
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while(in.ready()) {
			System.out.println("--");
			n = Integer.parseInt(in.readLine());
			list.clear();
			while(n-- > 0)	list.add(in.readLine());
			n = Integer.parseInt(in.readLine());
			while(n-- > 0)	play(in.readLine().toCharArray(),0,"");
		}
	}
}
