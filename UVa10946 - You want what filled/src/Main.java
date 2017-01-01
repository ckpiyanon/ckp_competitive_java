import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Pair<Integer,Character>> list = new ArrayList<Pair<Integer,Character>>();
		int TC = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(R == 0 && C == 0) break;
			list.clear();
			for(int i = 0;i < R;i++) grid[i] = in.readLine().toCharArray();
			for(int i = 0;i < R;i++) for(int j = 0;j < C;j++)
				if(grid[i][j] != '.') {
					char c = grid[i][j];
					list.add(Pair.make(floodfill(c,i,j),c));
				}
			Collections.sort(list);
			out.write("Problem " + ++TC + ":\n");
			for(Pair<Integer,Character> p:list)
				out.write(p.second + " " + p.first + "\n");
		}
		out.flush();
	}
	static int R,C;
	static int[] dr = {-1,1,0,0},dc = {0,0,-1,1};
	static char[][] grid = new char[50][];
	static int floodfill(char from,int r,int c) {
		grid[r][c] = '.';
		int ret = 1;
		for(int i = 0;i < 4;i++) {
			r += dr[i]; c += dc[i];
			if(r > -1 && c > -1 && r < R && c < C && grid[r][c] == from)
				ret += floodfill(from,r,c);
			r -= dr[i]; c -= dc[i];
		}
		return ret;
	}
	static class Pair<F extends Comparable<F>,S extends Comparable<S>> implements Comparable<Pair<F,S>> {
		F first; S second;
		Pair(F f,S s) {first = f; second = s;}
		public int compareTo(Pair<F,S> p) {
			int x = -first.compareTo(p.first);
			if(x == 0)	return second.compareTo(p.second);
			return x;
		}
		static <F extends Comparable<F>,S extends Comparable<S>> Pair<F,S> make(F f,S s) {return new Pair<F,S>(f,s);}
	}
}