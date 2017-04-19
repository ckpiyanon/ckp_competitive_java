import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		ArrayList<Node> list = new ArrayList<Node>();
		while(st.nextToken() != StreamTokenizer.TT_EOF)	list.add(new Node((int)st.nval,getInt()));
		Collections.sort(list);
		int[] dp = new int[list.size() + 1];
		int max = 0;
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0] = 0;
		for(Node node:list)	for(int j = max;j >= 0;j--) {
			int w = dp[j] + node.getWeight();
			if(w <= node.getStrength() && w < dp[j+1]) {
				dp[j+1] = w;
				max = Math.max(max,j+1);
			}
		}
		System.out.println(max);
	}
	static class Node implements Comparable<Node> {
		private int weight,strength;
		public Node(int w,int s) {weight = w; strength = s;}
		public int getWeight() {return weight;}
		public int getStrength() {return strength;}
		public int compareTo(Node n) {return strength - n.strength;}
		public String toString() {return weight + " " + strength;}
	}
}
