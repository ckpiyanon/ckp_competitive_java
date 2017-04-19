import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n,l,u,v;
		while(graph.size() < 200)	graph.add(new ArrayList<Integer>());
		while((n = getInt()) != 0) {
			for(int i = 0;i < n;i++)	graph.get(i).clear();
			l = getInt();
			while(l-- > 0) {
				u = getInt(); v = getInt();
				graph.get(u).add(v); graph.get(v).add(u);
			}
			Arrays.fill(color,0); color[0] = 1;
			if(!isBipartite(0))	System.out.print("NOT ");
			System.out.println("BICOLORABLE.");
		}
	}
	static int color[] = new int[200];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(200);
	static boolean isBipartite(int u) {
		for(Integer v:graph.get(u)) {
			if(color[v] != 0 && color[v] == color[u])	return false;
			else if(color[v] == 0) {
				color[v] = -color[u];
				if(!isBipartite(v))	return false;
			}
		}
		return true;
	}
}
