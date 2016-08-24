import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StreamTokenizer st;
	static boolean v[];
	static ArrayList<ArrayList<Integer>> graph;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static int bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		int ans = 0,tmp;
		while(!q.isEmpty()) {
			tmp = q.poll();
			if(v[tmp])	continue;
			v[tmp] = true;
			ans++;
			q.addAll(graph.get(tmp));
		}
		return ans;
	}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		v = new boolean[10000];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i < 10000;i++)	graph.add(new ArrayList<Integer>());
		int TC = getInt(),n,m,l,ans;
		while(TC-- > 0) {
			n = getInt();m = getInt();l = getInt();
			ans = 0;
			for(int i = 0;i < n;i++)	graph.get(i).clear();
			Arrays.fill(v,0,n,false);
			for(int i = 0;i < m;i++)	graph.get(getInt() - 1).add(getInt() - 1);
			for(int i = 0;i < l;i++)	ans += bfs(getInt() - 1);
			sb.append(ans);
			sb.append('\n');
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
