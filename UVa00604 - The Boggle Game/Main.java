import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s;
		boolean first = true;
		set.add(new TreeSet<String>()); set.add(new TreeSet<String>());
		while(true) {
			s = in.readLine();
			if(s.equals("#"))	break;
			st = new StringTokenizer(s);
			for(int x = 0;x < 2;x++)
				for(int i = 0;i < 4;i++)
					board[x][0][i] = st.nextToken().charAt(0);
			for(int k = 1;k < 4;k++) {
				st = new StringTokenizer(in.readLine());
				for(int x = 0;x < 2;x++)
					for(int i = 0;i < 4;i++)
						board[x][k][i] = st.nextToken().charAt(0);
			}
			in.readLine();
			set.get(0).clear(); set.get(1).clear();
			for(int i = 0;i < 4;i++) for(int j = 0;j < 4;j++) {run(i,j,"",0); run(i,j,"",1);}
			set.get(0).retainAll(set.get(1));
			if(!first)	out.write("\n");
			first = false;
			if(set.get(0).size() == 0)	out.write("There are no common words for this pair of boggle boards.\n");
			else for(String str:set.get(0))
				out.write(str + "\n");
		}
		out.flush();
	}
	static boolean[][] v = new boolean[4][4];
	static char board[][][] = new char[2][4][4];
	static ArrayList<Set<String>> set = new ArrayList<Set<String>>();
	static int[] dr = {-1,0,1,-1,1,-1,0,1};
	static int[] dc = {-1,-1,-1,0,0,1,1,1};
	static void run(int r,int c,String s,int idx) {
		s += board[idx][r][c];
		if(s.length() == 4) {
			if(countVowels(s) == 2)
				set.get(idx).add(s);
		}
		else {
			v[r][c] = true;
			for(int i = 0;i < 8;i++) {
				int nr = r + dr[i],nc = c + dc[i];
				if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || v[nr][nc])	continue;
				run(nr,nc,s,idx);
			}
			v[r][c] = false;
		}
	}
	static int countVowels(String s) {
		int ret = 0;
		for(char ch:s.toCharArray())
			if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y')
				ret++;
		return ret;
	}
}
