import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean v[];
	static int dfs(int a) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(a);
		int t,ans = 0;
		while(!stack.isEmpty()) {
			t = stack.pop();
			if(v[t])	continue;
			ans++;
			v[t] = true;
			stack.addAll(graph.get(t));
		}
		return ans;
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		StringBuilder sb = new StringBuilder();
		String inS = "";
		v = new boolean[26];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i < 26;i++)	graph.add(new ArrayList<Integer>());
		int TC = Integer.parseInt(in.readLine()),len,aT,aA,aTmp;
		while(TC-- > 0) {
			for(int i = 0;i < 26;i++)	graph.get(i).clear();
			Arrays.fill(v,false);
			inS = in.readLine();
			aT = aA = 0;
			while(inS.charAt(0) != '*') {
				graph.get(inS.charAt(1) - 'A').add((int)(inS.charAt(3) - 'A'));
				graph.get(inS.charAt(3) - 'A').add((int)(inS.charAt(1) - 'A'));
				inS = in.readLine();
			}
			inS = in.readLine(); len = inS.length();
			for(int i = 0;i < len;i += 2) {
				aTmp = inS.charAt(i) - 'A';
				if(v[aTmp])	continue;
				aTmp = dfs(aTmp);
				if(aTmp > 1)	aT++;
				else			aA++;
			}
			sb.append("There are ");
			sb.append(aT);
			sb.append(" tree(s) and ");
			sb.append(aA);
			sb.append(" acorn(s).\n");
		}
		out.write(sb.toString().getBytes());
		out.flush();
		in.close();
		out.close();
	}
}
