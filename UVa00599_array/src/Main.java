import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean graph[][] = new boolean[26][26];
	static boolean v[] = new boolean[26];
	static int dfs(int start) {
		if(v[start])
			return 0;
		int ans = 1;
		v[start] = true;
		for(int i = 0;i < 26;i++) {
			if(graph[start][i])
				ans += dfs(i);
		}
		
		return ans;
	}
	public static void main(String args[]) throws IOException {
		long _time = System.currentTimeMillis();
		try {
			System.setIn(new FileInputStream(new File("input.txt")));
		}catch(FileNotFoundException e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		int tree,acorn,tI;
		String t;
		StringTokenizer st;
		while(TC-- > 0) {
			for(int i = 0;i < 26;i++)
				v[i] = false;
			for(int i = 0;i < 26;i++)
				for(int j = 0;j < 26;j++)
					graph[i][j] = false;
			t = in.readLine();
			while(t.charAt(0) != '*') {
				graph[t.charAt(1) - 'A'][t.charAt(3) - 'A'] = true;
				graph[t.charAt(3) - 'A'][t.charAt(1) - 'A'] = true;
				t = in.readLine();
			}
			t = in.readLine();
			st = new StringTokenizer(t,",");
			tree = acorn = 0;
			while(st.hasMoreTokens()) {
				tI = dfs((int)st.nextToken().charAt(0) - 'A');
				if(tI > 1)
					tree++;
				else if(tI == 1)
					acorn++;
			}
			out.write("There are " + tree + " tree(s) and " + acorn + " acorn(s).\n");
		}
		out.write("\n\n" + (System.currentTimeMillis() - _time));
		in.close();
		out.flush();
		out.close();
	}
}
