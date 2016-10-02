import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int size = 0;
		while(st.nextToken() != StreamTokenizer.TT_EOF)
			list[size++] = new Node((int)st.nval,getInt());
		Arrays.sort(list,0,size,new Comparator<Node>() {public int compare(Node a,Node b) {return a.weight - b.weight;}});
		int[] dp = new int[size + 1],prev = new int[size + 1];
		int max = 0,idx;
		for(int i = 1;i <= size;i++) {
			idx = 0;
			for(int j = 1;j < i;j++)
				if(list[i-1].iq < list[j-1].iq && list[i-1].weight > list[j-1].weight && dp[j] > dp[idx])
					idx = j;
			dp[i] = dp[idx] + 1;
			prev[i] = idx;
			max = Math.max(max,dp[i]);
		}
		System.out.println(max);
		idx = size;
		while(dp[idx] != max)	idx--;
		trace(prev,idx);
	}
	static void trace(int[] prev,int idx) {
		if(idx == 0)	return;
		trace(prev,prev[idx]);
		System.out.println(list[idx - 1].id);
	}
	static Node[] list = new Node[1000];
	static class Node {
		int weight,iq,id;
		Node(int w,int i) {weight = w; iq = i; id = ++order;}
		static boolean less(Node a,Node b) {return a.weight < b.weight && a.iq > b.iq;}
		static boolean more(Node a,Node b) {return a.weight > b.weight && a.iq < b.iq;}
		public String toString() {return "(" + weight + "," + iq + ")";}
		static int order = 0;
	}
}
