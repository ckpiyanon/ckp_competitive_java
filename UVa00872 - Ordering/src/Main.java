import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static BufferedWriter out;
	static String[] rmap = new String[20];
	static Map<String,Integer> map = new TreeMap<String,Integer>();
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(20);
	static int varCount,visited,orderCount;
	static int[] inDeg = new int[20];
	static void setVisited(int n) {visited |= (1 << n);}
	static void setUnvisited(int n) {visited &= ~(1 << n);}
	static boolean isVisited(int n) {return ((visited >> n) & 1) == 1;}
	static void play(int idx,int count,String output) throws Exception {
		if(count == varCount) {
			orderCount++;
			out.write(output + "\n");
			return;
		}
		for(Integer v:graph.get(idx)) if(inDeg[v] > 0)	inDeg[v]--;
		for(int v = 0;v < varCount;v++) if(inDeg[v] == 0 && !isVisited(v)) {
			setVisited(v);
			play(v,count + 1,output + " " + rmap[v]);
			setUnvisited(v);
		}
		for(Integer v:graph.get(idx))	inDeg[v]++;
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st,st0;
		String str;
		int TC = Integer.parseInt(in.readLine());
		for(int i = 0;i < 20;i++)	graph.add(new ArrayList<Integer>());
		for(int tc = 0;tc < TC;tc++) {
			if(tc > 0)	out.write("\n");
			varCount = 0;
			map.clear();
			for(ArrayList<Integer> each:graph)	each.clear();
			in.readLine();
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()) {
				map.put(str = st.nextToken(),varCount);
				rmap[varCount++] = str;
			}
			st = new StringTokenizer(in.readLine());
			Arrays.fill(inDeg,0);
			while(st.hasMoreTokens()) {
				st0 = new StringTokenizer(st.nextToken(),"<");
				int u = map.get(st0.nextToken()),v = map.get(st0.nextToken());
				graph.get(u).add(v);
				inDeg[v]++;
			}
			orderCount = visited = 0;
			for(int v = 0;v < varCount;v++) if(inDeg[v] == 0) {
				setVisited(v);
				play(v,1,rmap[v]);
				setUnvisited(v);
			}
			if(orderCount == 0)	out.write("NO\n");
			out.flush();
		}
	}
}
