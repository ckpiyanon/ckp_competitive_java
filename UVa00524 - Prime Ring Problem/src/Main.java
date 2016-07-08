import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Main {
	static BitSet visited = new BitSet(16);
	static ArrayList<ArrayList<Integer>> graph;
	static int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37};
	
	static boolean isPrime(int n) {return Arrays.binarySearch(prime,n) > -1;}
	static int max;
	static StringBuilder sb = new StringBuilder("1");
	static void dfs(int u,int num) throws Exception {
		int len = sb.length();
		if(num == max) {
			if(isPrime(u + 1))	out.write(sb.append("\n").toString());
			return;
		}
		for(int v:graph.get(u)) {
			if(v > max)	break;
			if(!visited.get(v) && isPrime(u + v)) {
				visited.set(v,true);
				sb.append(' ').append(v);
				dfs(v,num + 1);
				visited.set(v,false);
				sb.delete(len,sb.length());
			}
		}
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int TC = 0;
		graph = new ArrayList<ArrayList<Integer>>(17);
		graph.add(null);
		while(graph.size() <= 16) graph.add(new ArrayList<Integer>());
		for(int i = 1;i <= 16;i++) for(int j = i + 1;j <= 16;j++)
			if(isPrime(i + j)) {graph.get(i).add(j); graph.get(j).add(i);}
		while((s = in.readLine()) != null) {
			if(TC > 0)	out.write("\n");
			visited.clear(); visited.set(1);
			out.write("Case " + ++TC + ":\n");
			max = Integer.parseInt(s);
			dfs(1,1);
		}
		out.flush();
	}
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
}
