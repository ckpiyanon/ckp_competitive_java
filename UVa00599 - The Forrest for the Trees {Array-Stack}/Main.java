import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static boolean graph[][] = new boolean[26][26];
	static int v[] = new int[26];
	static int dfs(int start) {
		Stack<Integer> stack = new Stack<Integer>();
		int ans = 0,tmp;
		stack.push(start);
		while(!stack.isEmpty()) {
			tmp = stack.pop().intValue();
			if(v[tmp] > 1)	continue;
			ans++;
			v[tmp] = 2;
			for(int i = 0;i < 26;i++)
				if(graph[i][tmp] && v[i] == 0) {
					stack.push(i);
					v[i] = 1;
				}
		}
		return ans;
	}
	public static void main(String args[]) throws IOException {
		long _time = System.currentTimeMillis();
		try {
			System.setIn(new FileInputStream(new File("input.txt")));
		} catch (FileNotFoundException e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC,tmp,tree,acorn,cnt;
		String inpTmp;
		TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			for(int i = 0;i < 26;i++)
				for(int j = 0;j < 26;j++)
					graph[i][j] = false;
			for(int i = 0;i < 26;i++)
				v[i] = 0;
			inpTmp = in.readLine();
			while(inpTmp.charAt(0) != '*') {
				graph[inpTmp.charAt(1) - 'A'][inpTmp.charAt(3) - 'A'] = true;
				graph[inpTmp.charAt(3) - 'A'][inpTmp.charAt(1) - 'A'] = true;
				inpTmp = in.readLine();
			}
			inpTmp = in.readLine();
			acorn = tree = cnt = 0;
			do {
				tmp = dfs(inpTmp.charAt(cnt) - 'A');
				if(tmp > 1)
					tree++;
				else if(tmp == 1)
					acorn++;
				cnt += 2;
			}
			while(cnt < inpTmp.length());
			out.write("There are " + tree + " tree(s) and " + acorn + " acorn(s).\n");
		}
		out.write("\n\n" + (System.currentTimeMillis() - _time));
		in.close();
		out.flush();
		out.close();
	}
}
