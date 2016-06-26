import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		boolean graph[][] = new boolean[200][200],isBipartite;
		int TC,n,p,x,ans,colourCount[] = {0,0},colour[] = new int[200];
		Queue<Integer> q = new LinkedList<Integer>();
		TC = getInt();
		while(TC-- > 0) {
			n = getInt();
			for(boolean[] am:graph)	Arrays.fill(am,false);
			for(int i = 0;i < n;i++) {
				p = getInt();
				while(p-- > 0) {
					x = getInt() - 1;
					graph[x][i] = graph[i][x] = true;
				}
			}
			Arrays.fill(colour,-1);
			ans = 0;
			for(int i = 0;i < n;i++) {
				if(colour[i] != -1)	continue;
				
				isBipartite = true;
				q.clear();
				q.add(i);
				colour[i] = 0;
				colourCount[0] = 1;
				colourCount[1] = 0;
				while(!q.isEmpty()) {
					x = q.poll();
					for(int v = 0;v < n;v++) {
						if(!graph[x][v])	continue;
						if(colour[v] == -1) {
							colour[v] = 1 - colour[x];
							colourCount[colour[v]]++;
							q.add(v);
						}
						else if(colour[v] == colour[x])	isBipartite = false;
					}
				}
				if(isBipartite)	ans += Math.max(colourCount[0],colourCount[1]);
			}
			System.out.println(ans);
		}
	}
}