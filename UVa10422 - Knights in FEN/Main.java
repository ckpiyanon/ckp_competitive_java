import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	static int dr[] = {-1,-1,1,1,-2,-2,2,2};
	static int dc[] = {-2,2,-2,2,-1,1,-1,1};
	static int dp[] = {-7,-3,3,7,-11,-9,9,11};
	static String swap(String s,int p1,int p2) {
		StringBuilder sb = new StringBuilder(s);
		char c = sb.charAt(p1);
		sb.setCharAt(p1,sb.charAt(p2));
		sb.setCharAt(p2,c);
		return sb.toString();
	}
	public static void main(String args[]) throws Exception {
		Map<String,Integer> map = new HashMap<String,Integer>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node("111110111100 110000100000",0,12));
		map.put("111110111100 110000100000",0);
		while(!q.isEmpty()) {
			Node node = q.poll();
			int r = node.p / 5,c = node.p % 5;
			for(int i = 0;i < 8;i++) {
				int nr = r + dr[i],nc = c + dc[i];
				if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5)	continue;
				Node n = node.move(i);
				if(!map.containsKey(n.s)) {
					map.put(n.s,n.w);
					if(n.w < 10)	q.add(n);
				}
			}
		}
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb;
		while(TC-- > 0) {
			sb = new StringBuilder();
			for(int i = 0;i < 5;i++)	sb.append(in.readLine());
			if(map.containsKey(sb.toString()))	System.out.printf("Solvable in %d move(s).\n",map.get(sb.toString()));
			else	System.out.printf("Unsolvable in less than 11 move(s).\n");
		}
	}
	static class Node {
		String s;
		int w,p;
		public Node(String s,int w,int spos) {
			this.s = s; this.w = w; this.p = spos;
		}
		public Node move(int i) {
			int np = p + dp[i];
			return new Node(swap(s,p,np),w+1,np);
		}
	}
}
