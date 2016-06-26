import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String pre,cur;
		StringBuilder sb = new StringBuilder();
		int w[] = new int[26],has = 0;
		@SuppressWarnings("unchecked") ArrayList<Integer> graph[] = new ArrayList[26];
		for(int i = 0;i < 26;i++) graph[i] = new ArrayList<Integer>();
		pre = in.readLine();
		for(char c:pre.toCharArray()) has |= 1 << (c - 'A');
		while((cur = in.readLine()).charAt(0) != '#') {
			for(char c:cur.toCharArray()) has |= 1 << (c - 'A');
			int i = 0,len = Math.min(pre.length(),cur.length());
			while(i < len && pre.charAt(i) == cur.charAt(i)) i++;
			if(i < len)graph[pre.charAt(i) - 'A'].add(cur.charAt(i) - 'A');
			pre = cur;
		}
		for(ArrayList<Integer> arr:graph) for(Integer v:arr) w[v]++;
		while(has != 0) for(int i = 0;i < 26;i++) if((has >> i) % 2 == 1 && w[i] == 0) {
			sb.append((char)(i + 'A'));
			for(Integer v:graph[i])	w[v]--;
			w[i]--;
			has &= ~(1 << i);
		}
		System.out.println(sb);
	}
}
