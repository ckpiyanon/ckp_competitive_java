import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StreamTokenizer st;
	static double getNum() throws Exception {st.nextToken(); return st.nval;}
	static int getInt() throws Exception {return (int)getNum();}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(202);
		for(int i = 0;i < 202;i++)	graph.add(new ArrayList<Integer>());
		int n,m,sec,v,d;
		double[][] pos = new double[100][2];
		int[][] weight = new int[202][202];
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval; m = getInt(); sec = getInt(); v = getInt();
			d = v * sec;
			for(int[] each:weight)	Arrays.fill(each,0);
			for(ArrayList<Integer> each:graph)	each.clear();
			for(int i = 0;i < 100;i++) {
				weight[0][gopher(i)] = 1;
				weight[hole(i)][1] = 1;
				graph.get(0).add(gopher(i));
				graph.get(gopher(i)).add(0);
				graph.get(hole(i)).add(1);
				graph.get(1).add(hole(i));
			}
			for(int i = 0;i < n;i++) {pos[i][0] = getNum(); pos[i][1] = getNum();}
			for(int i = 0;i < m;i++) {
				double x = getNum(),y = getNum();
				for(int j = 0;j < n;j++)
					if(Math.sqrt(Math.pow(pos[j][0] - x,2) + Math.pow(pos[j][1] - y,2)) <= d) {
						graph.get(gopher(j)).add(hole(i));
						graph.get(hole(i)).add(gopher(j));
						weight[gopher(j)][hole(i)] = 1;
					}
			}
			int ans = 0;
			while(bfs(0,1,graph,weight)) {
				int u = 1;
				while(u != 0) {
					weight[parent[u]][u]--;
					weight[u][parent[u]]++;
					u = parent[u];
				}
				ans++;
			}
			out.write(n - ans + "\n");
		}
		out.flush();
	}
	static BitSet visited = new BitSet(202);
	static int[] parent = new int[202];
	static boolean bfs(int s,int t,ArrayList<ArrayList<Integer>> graph,int[][] weight) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited.clear();
		q.add(s);
		while(!q.isEmpty()) {
			int u = q.poll();
			if(u == t)	return true;
			for(Integer v:graph.get(u)) if(!visited.get(v) & weight[u][v] != 0) {
				visited.set(v,true); parent[v] = u;
				q.add(v);
			}
		}
		return false;
	}
	static int gopher(int n) {return n + 2;}
	static int hole(int n) {return n + 102;}
}