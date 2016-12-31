import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int m;
		for(int i = 0;i < 100;i++)	graph.add(new ArrayList<Integer>());
		while((n = getInt()) != 0 & (m = getInt()) != 0) {
			for(int i = 0;i < n;i++)	graph.get(i).clear();
			while(m-- > 0)	graph.get(getInt() - 1).add(getInt() - 1);
			Arrays.fill(deg,0);
			for(int i = 0;i < n;i++) for(Integer v:graph.get(i)) deg[v]++;
			bfs();
			for(int i = 0;i < list.size();i++)
				out.write((list.get(i) + 1) + (i == list.size() - 1 ? "\n":" "));
		}
		out.flush();
	}
	static int n;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(100);
	static ArrayList<Integer> list = new ArrayList<Integer>(100);
	static int[] deg = new int[100];
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0;i < n;i++) if(deg[i] == 0)	q.add(i);
		list.clear();
		while(!q.isEmpty()) {
			int u = q.poll();
			list.add(u);
			for(Integer v:graph.get(u)) {
				deg[v]--;
				if(deg[v] == 0)	q.add(v);
			}
		}
	}
}
