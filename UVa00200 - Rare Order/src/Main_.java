import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_ {
	@SuppressWarnings("unchecked")
	static ArrayList<Integer> graph[] = new ArrayList[26];
	static int w[] = new int[26];
	static int visited;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int u) {
		if((visited >> u) % 2 == 1 || w[u] > 0) return;
		sb.append((char)(u + 'A'));
		visited |= 1 << u;
		for(Integer v:graph[u]) {
			w[v]--;
			if((visited >> u) % 2 == 0 || w[u] == 0) dfs(v);
		}
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String pre,cur;
		int has = 0;
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
		for(int i = 0;i < 26;i++) if((has >> i) % 2 == 1 && w[i] == 0) {
			dfs(i);
			break;
		}
		System.out.println(sb);
	}
}
