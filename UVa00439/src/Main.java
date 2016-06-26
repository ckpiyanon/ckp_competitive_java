import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

public class Main {
	static int rd,cd,dr[] = {-2,-2, 2, 2,-1, 1,-1, 1},dc[] = {-1, 1,-1, 1,-2,-2, 2, 2};
	static boolean map[][];
	static int play(int r,int c) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(r,c,0));
		Node tmp;
		int nr,nc,l;
		while(!q.isEmpty()) {
			tmp = q.poll();
			r = tmp.X;
			c = tmp.Y;
			l = tmp.L;
			if(map[r][c])	continue;
			map[r][c] = true;
			if(r == rd && c == cd)	return l;
			for(int i = 0;i < 8;i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if(nr < 0 || nr >= 8 || nc < 0 || nc >= 8)	continue;
				q.add(new Node(nr,nc,l+1));
			}
		}
		return 0;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s1,s2;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			s1 = st.sval;
			st.nextToken();
			s2 = st.sval;
			rd = s2.charAt(0) - 'a';
			cd = s2.charAt(1) - '1';
			map = new boolean[8][8];
			out.write("To get from ");
			out.write(s1);
			out.write(" to ");
			out.write(s2);
			out.write(" takes ");
			out.write(String.valueOf(play(s1.charAt(0) - 'a',s1.charAt(1) - '1')));
			out.write(" knight moves.\n");
		}
		out.flush();
	}
	static class Node implements Comparable<Node> {
		public int X,Y,L;
		public Node(int X,int Y,int L) {
			this.X = X;
			this.Y = Y;
			this.L = L;
		}
		public int compareTo(Node node) {
			return this.L - node.L;
		}
	}
}
