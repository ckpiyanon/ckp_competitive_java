import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String args[]) throws Exception {
		new Main().run();
	}
	StreamTokenizer st; BufferedReader in; BufferedWriter out;
	void setIO() throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StreamTokenizer(in);
	}
	String getS() throws Exception {st.nextToken(); return st.sval;}
	double getNum() throws Exception {st.nextToken(); return st.nval;}
	int getInt() throws Exception {return (int)getNum();}
	void run() throws Exception {setIO(); sol();}
	void sol() throws Exception {
		for(int i = 0;i < 1000;i++)	graph.add(new ArrayList<Integer>());
		int u,v;
		while(true) {
			n = getInt(); m = getInt();
			if(n == 0 && m == 0)	break;
			for(int i = 0;i < n;i++) graph.get(i).clear();
			while(m-- > 0) {
				u = getInt(); v = getInt();
				graph.get(u).add(v); graph.get(v).add(u);
			}
			bridges.clear(); rank = 0; visited.clear();
			Arrays.fill(low,-1); Arrays.fill(num,-1);
			for(int i = 0;i < n;i++) if(!visited.get(i)) dfs(i);
			Collections.sort(bridges,new Comparator<Pair>() {
				public int compare(Pair a,Pair b) {return a.u == b.u ? a.v - b.v:a.u - b.u;}
			});
			out.write(String.valueOf(bridges.size()));
			for(Pair p:bridges)	out.write(" " + p);
			out.write("\n");
		}
		out.flush();
	}
	ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(1000);
	ArrayList<Pair> bridges = new ArrayList<Pair>();
	BitSet visited = new BitSet(1000);
	int n,m,rank;
	int[] num = new int[1000],low = new int[1000],parent = new int[1000];
	void dfs(int u) {
		low[u] = num[u] = rank++;
		visited.set(u,true);
		for(Integer v:graph.get(u)) {
			if(!visited.get(v)) {
				parent[v] = u;
				dfs(v);
				low[u] = Math.min(low[u],low[v]);
				if(low[v] > num[u])	bridges.add(new Pair(Math.min(u,v),Math.max(u,v)));
			}
			else if(parent[u] != v)	low[u] = Math.min(low[u],num[v]);
		}
	}
	class Pair {
		public final int u,v;
		public Pair(int u,int v) {this.u = u; this.v = v;}
		public String toString() {return u + " " + v;}
	}
}