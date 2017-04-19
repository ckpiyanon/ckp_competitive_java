import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Main {
	static final int INF = -100000000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean infCycle,winnable;
		int n;
		for(int i = 0;i < 100;i++)	graph.add(new ArrayList<Integer>());
		while((n = getInt()) != -1) {
			visited.clear();
			Arrays.fill(weight,INF);
			for(int i = 0;i < n;i++) {
				graph.get(i).clear();
				energy[i] = getInt();
				int m = getInt();
				while(m-- > 0)	graph.get(i).add(getInt() - 1);
			}
			weight[0] = 100;
			for(int iter = 1;iter < n;iter++)
				for(int u = 0;u < n - 1;u++)
					if(weight[u] > 0)
						for(Integer v:graph.get(u))
							if(weight[u] + energy[v] > weight[v])
								weight[v] = weight[u] + energy[v];
			infCycle = winnable = false;
			for(int u = 0;u < n - 1 && !winnable;u++)
				if(weight[u] > 0)
					for(Integer v:graph.get(u))
						if(weight[u] + energy[v] > weight[v]) {
							infCycle = true;
							visited.clear();
							if(winnable = dfs(u,n-1))	break;
						}
			if(!infCycle)	winnable = weight[n-1] > 0;
			out.write(winnable ? "winnable\n":"hopeless\n");
		}
		out.flush();
	}
	static int[] energy = new int[100],weight = new int[100];
	static BitSet visited = new BitSet(100);
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(100);
	static boolean dfs(int s,int t) {
		if(s == t)	return true;
		visited.set(s,true);
		for(Integer v:graph.get(s)) if(!visited.get(v))
			if(dfs(v,t))	return true;
		visited.set(s,false);
		return false;
	}
}
