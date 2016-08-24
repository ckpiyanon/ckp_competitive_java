import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	static final boolean BLACK = false;
	static final boolean RED = true;
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static ArrayList<ArrayList<Integer>> graph;
	static BitSet visited;
	static boolean colour[];
	static int getColour(boolean c) {return c ? 0:1;}
	static boolean bipartiteCheck(int u,boolean colourToSet,int[] numColour) {
		if(visited.get(u) && colourToSet != colour[u])	return false;
		if(visited.get(u))	return true;
		visited.set(u,true);
		colour[u] = colourToSet;
		numColour[getColour(colourToSet)]++;
		for(Integer v:graph.get(u))
			if(!bipartiteCheck(v,!colourToSet,numColour))
				return false;
		return true;
	}
	public static void main(String args[]) throws Exception {
		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		try{System.setOut(new PrintStream("out.txt"));}catch(Exception e){}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		colour = new boolean[200];
		graph = new ArrayList<ArrayList<Integer>>();
		visited = new BitSet(200);
		for(int i = 0;i < 200;i++)	graph.add(new ArrayList<Integer>());
		int TC = getInt(),V,E;
		while(TC-- > 0) {
			for(ArrayList<Integer> arr:graph)	arr.clear();
			visited.clear();
			V = getInt();
			E = getInt();
			while(E-- > 0) {
				int u = getInt(),v = getInt();
				if(u >= V || v >= V)	continue;
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			int ans = 0;
			for(int i = 0;i < V && ans >= 0;i++) {
				if(visited.get(i))	continue;
				int[] num = {0,0};
				if(bipartiteCheck(i,false,num))
					ans += Math.max(num[0],num[1]);
				else ans = -1;
			}
			System.out.println(ans);
		}
	}
}
