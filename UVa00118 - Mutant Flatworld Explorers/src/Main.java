import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.TreeSet;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		TreeSet<Pair> set = new TreeSet<Pair>();
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int R = getInt(),U = getInt(),x,y,idx;
		int[] dirx = {0,1,0,-1},diry = {1,0,-1,0};
		char ch,cmd[];
		boolean lost;
		String dir = "NESW";
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			x = (int)st.nval;
			y = getInt();
			ch = getString().charAt(0);
			cmd = getString().toCharArray();
			idx = dir.indexOf(ch);
			lost = false;
			for(int i = 0;i < cmd.length && !lost;i++) {
				switch(cmd[i]) {
				case 'L': idx = (idx + 3) % 4; break;
				case 'R': idx = (idx + 1) % 4; break;
				case 'F':
					if(!set.contains(new Pair(x,y))) {
						x += dirx[idx]; y += diry[idx];
					}
					else {
						int nx = x + dirx[idx];
						int ny = y + diry[idx];
						if(!(nx < 0 || nx > R || ny < 0 || ny > U)) {
							x += dirx[idx]; y += diry[idx];
						}
					}
					break;
				}
				if(x < 0 || y < 0 || x > R || y > U) {
					lost = true;
					x -= dirx[idx]; y -= diry[idx];
					set.add(new Pair(x,y));
				}
			}
			System.out.print(x + " " + y + " " + dir.charAt(idx));
			if(lost)	System.out.println(" LOST");
			else	System.out.println();
		}
	}
	static class Pair implements Comparable<Pair> {
		public int x,y;
		public Pair(int x,int y) {this.x = x; this.y = y;}
		public int compareTo(Pair o) {if(x == o.x) return y - o.y; return x - o.x;}
	}
}
