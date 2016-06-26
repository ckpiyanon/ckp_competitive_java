import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	
	static int n,m;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	static char[][] arr = new char[1001][];
	static void floodfill(int r,int c,char from,char to) {
		if(r < 0 || r >= n || c < 0 || c >= m || arr[r][c] != from)	return;
		arr[r][c] = to;
		for(int i = 0;i < 4;i++)
			floodfill(r + dr[i],c + dc[i],from,to);
	}
	
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt();
		boolean[] has = new boolean[26];
		int[] lang = new int[26];
		ArrayList<Character> list = new ArrayList<Character>();
		for(int x = 1;x <= TC;x++) {
			System.out.println("World #" + x);
			n = getInt(); m = getInt();
			Arrays.fill(has,false); Arrays.fill(lang,0); list.clear();
			for(int i = 0;i < n;i++)	arr[i] = getString().toCharArray();
			for(int i = 0;i < n;i++) for(int j = 0;j < m;j++) {
				if(arr[i][j] != ' ') {
					if(!has[arr[i][j] - 'a']) {
						has[arr[i][j] - 'a'] = true;
						list.add(arr[i][j]);
					}
					lang[arr[i][j] - 'a']++;
					floodfill(i,j,arr[i][j],' ');
				}
			}
			Collections.sort(list,new Comp(lang));
			for(Character c:list)	System.out.println(c + ": " + lang[c - 'a']);
		}
	}
	static class Comp implements Comparator<Character> {
		public int compare(Character a,Character b) {
			return lang[b - 'a'] == lang[a - 'a'] ? (a - b):(lang[b - 'a'] - lang[a - 'a']);
		}
		public int[] lang;
		public Comp(int[] lang) {
			this.lang = lang;
		}
	}
}
