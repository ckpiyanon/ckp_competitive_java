import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int[] graph = new int[50000];
	static int[] storage = new int[50000];
	static boolean[] v = new boolean[50000];
	static int getInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	static void dfs(int u) {
		if(storage[u] >= 0)	return;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int f;
		while(u != -1 && !v[u]) {
			list.add(u);
			v[u] = true;
			u = graph[u];
		}
		f = list.size() - 1;
		if(u == -1)					storage[list.get(list.size() - 1)] = 1;
		else if(storage[u] >= 0)	storage[list.get(list.size() - 1)] = storage[u] + 1;
		else if(v[u]) {
			f = 0;
			while(list.get(f).intValue() != u) f++;
			int x = list.size() - f;
			for(int i = f;i < list.size();i++)	storage[list.get(i)] = x;
		}
		for(int i = f-1;i >= 0;i--)	storage[list.get(i)] = 1 + storage[list.get(i+1)];
	}
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("in0.txt")));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = getInt(),q,from,to,maxInp,maxAns,ans = 0;
		for(int nth = 1;nth <= TC;nth++) {
			Arrays.fill(graph,-1);
			Arrays.fill(storage,-1);
			Arrays.fill(v,false);
			maxInp = maxAns = Integer.MIN_VALUE;
			q = getInt();
			while(q-- > 0) {
				from = getInt();
				to = getInt();
				maxInp = Math.max(maxInp,Math.max(from,to));
				graph[from - 1] = to - 1;
			}
			for(int i = 0;i < maxInp;i++)	dfs(i);
			for(int i = 0;i < maxInp;i++) {
				if(maxAns < storage[i]) {
					maxAns = storage[i];
					ans = i;
				}
			}
			out.write("Case " + nth + ": " + (ans + 1) + "\n");
		}
		out.flush();
		out.close();
	}
}
