import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt();
		while(TC-- > 0) {
			int nS = getInt(),nA = getInt(),m = getInt(),n = (nS + nA) * 2;
			for(boolean[] each:graph)	Arrays.fill(each,false);
			while(m-- > 0) {
				int s1 = getInt() - 1,a1 = getInt() + nS - 1,s2 = getInt() - 1,a2 = getInt() + nS - 1;
				int distS = s1 - s2,distA = a1 - a2;
				if(distS == 0 && distA == 0)	continue;
				int dirS = distA > 0 ? 1:0;
				int dirA = distS > 0 ? 1:0;
				if(distS == 0)
					add(s1,dirS ^ 1,s1,dirS);
				else if(distA == 0)
					add(a1,dirA ^ 1,a1,dirA);
				else {
					add(s1,dirS^1,s2,dirS);	add(s1,dirS^1,a1,dirA);
					add(a2,dirA^1,s2,dirS);	add(a2,dirA^1,a1,dirA);
					add(s2,dirS^1,s1,dirS);	add(s2,dirS^1,a2,dirA);
					add(a1,dirA^1,s1,dirS);	add(a1,dirA^1,a2,dirA);
				}
			}
			for(int k = 0;k < n;k++)
				for(int i = 0;i < n;i++)
					for(int j = 0;j < n;j++)
						graph[i][j] |= graph[i][k] && graph[k][j];
			boolean yes = true;
			for(int i = 0;i < n && yes;i += 2)
				if(graph[i][i^1] && graph[i^1][i])
					yes = false;
			System.out.println(yes ? "Yes":"No");
		}
	}
	static final int MAXN = 120;
	static boolean[][] graph = new boolean[MAXN][MAXN];
	static void add(int from,int f,int to,int t) {graph[from*2 + f][to*2 + t] = true;}
}
