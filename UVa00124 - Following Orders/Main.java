import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static BufferedWriter out;
	static int w[],n;
	static ArrayList<ArrayList<Integer>> graph;
	static void dfs(String str) throws Exception {
		if(str.length() == n) {
			out.write(str + "\n");
			return;
		}
		for(int i = 0;i < 26;i++) {
			if(w[i] == 0) {
				w[i]--;
				for(int a: graph.get(i))	w[a]--;
				dfs(str + (char)(i + 'a'));
				for(int a: graph.get(i))	w[a]++;
				w[i]++;
			}
		}
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		String inp;
		int f,t;
		w = new int[26];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i < 26;i++)
			graph.add(new ArrayList<Integer>());
		while((inp = in.readLine()) != null) {
			Arrays.fill(w,-1);
			for(int i = 0;i < 26;i++) graph.get(i).clear();
			n = (inp.length() / 2) + 1;
			for(int i = 0;i < inp.length();i += 2)
				w[inp.charAt(i) - 'a'] = 0;
			inp = in.readLine();
			for(int i = 0;i < inp.length();i += 4) {
				f = inp.charAt(i) - 'a';
				t = inp.charAt(i + 2) - 'a';
				w[t]++;
				graph.get(f).add(t);
			}
			dfs("");
			if(in.ready())	out.write("\n");
		}
		out.flush();
	}
}
