import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(562500);
		int ans[] = new int[750],list[] = new int[750],n;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval;
			for(int x = 0;x < n;x++) {
				for(int i = 0;i < n;i++)	list[i] = getInt();
				Arrays.sort(list,0,n);
				if(x == 0) for(int i = 0;i < n;i++)	ans[i] = list[i];
				else {
					pq.clear();
					for(int i = 0;i < n;i++)	pq.add(new Pair(ans[i] + list[0],0));
					for(int i = 0;i < n;i++) {
						Pair p = pq.poll();
						ans[i] = p.x;
						if(p.y + 1 < n)	pq.add(new Pair(p.x - list[p.y] + list[p.y + 1],p.y + 1));
					}
				}
			}
			for(int i = 0;i < n;i++)	out.write(ans[i] + (i == n - 1 ? "\n":" "));
		}
		out.flush();
	}
	static class Pair implements Comparable<Pair> {
		int x,y;
		Pair(int xx,int yy) {x = xx; y = yy;}
		public int compareTo(Pair p) {return x - p.x;}
	}
}
