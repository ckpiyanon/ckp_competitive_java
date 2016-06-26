import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static final int MAXSIZE = 1300;
	static int N,graph[][] = new int[MAXSIZE][MAXSIZE];
	static Map<String,Integer> nameMap,clubMap,partyMap;
	static Set<Integer> nameSet,clubSet,partySet;
	static BitSet visited = new BitSet(1300);
	static int source() {return 0;}
	static int target() {return 1;}
	static int get(Map<String,Integer> map,String s) {
		if(map.containsKey(s))	return map.get(s);
		map.put(s,++N);
		return N;
	}
	static int maxflow(int s,int min) {
		int flow;
		visited.set(s,true);
		if(s == target())	return min;
		for(int i = 0;i <= N;i++) {
			if(!visited.get(i) && graph[s][i] > 0 && (flow = maxflow(i,Math.min(min,graph[s][i]))) != 0) {
				graph[s][i] -= flow;
				graph[i][s] += flow;
				return flow;
			}
		}
		return 0;
	}
	public static void main(String args[]) throws Exception {
		try{System.setIn(new FileInputStream("in.txt"));}catch(Exception e){}
		nameMap = new HashMap<String,Integer>();
		clubMap = new HashMap<String,Integer>();
		partyMap = new HashMap<String,Integer>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s,name,tmpS;
		int TC = Integer.parseInt(in.readLine());
		in.readLine();
		while(TC-- > 0) {
			N = 1;
			nameMap.clear(); clubMap.clear(); partyMap.clear();
			for(int[] arr: graph)	Arrays.fill(arr,0);
			while((s = in.readLine()) != null && s.length() != 0) {
				st = new StringTokenizer(s);
				name = st.nextToken();
				tmpS = st.nextToken();
				graph[get(nameMap,name)][get(partyMap,tmpS)] = 1;
				while(st.hasMoreTokens()) {
					tmpS = st.nextToken();
					graph[get(clubMap,tmpS)][get(nameMap,name)] = 1;
					graph[source()][get(clubMap,tmpS)] = 1;
				}
			}
			int max = (clubMap.size() - 1) / 2;
			for(Entry<String,Integer> entry: partyMap.entrySet())
				graph[entry.getValue()][target()] = max;
			int ans = 0,flow;
			visited.clear();
			while((flow = maxflow(source(),Integer.MAX_VALUE)) > 0) {
				visited.clear();
				ans += flow;
			}
			if(ans != clubMap.size())
				System.out.println("Impossible.");
			else
				for(Entry<String,Integer> eachName: nameMap.entrySet())
					for(Entry<String,Integer> eachClub: clubMap.entrySet())
						if(graph[eachName.getValue()][eachClub.getValue()] > 0) {
							System.out.println(eachName.getKey() + " " + eachClub.getKey());
							break;
						}
			if(TC > 0)	System.out.println();
		}
	}
}