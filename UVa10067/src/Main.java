import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.BitSet;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static BitSet avail = new BitSet(10000);
	static BitSet visited = new BitSet(10000);
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	static int next(int n,boolean inc,int col) {
		int t = (int)Math.pow(10,col);
		int x = (n / t) % 10;
		if(inc) {
			if(x < 9)	return n + t;
			return n - t*9;
		}
		if(x > 0)	return n - t;
		return n + t*9;
	}
	static int bfs(int s,int t) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int u,w,v;
		visited.clear();
		pq.add(new Pair(0,s));
		while(!pq.isEmpty()) {
			Pair e = pq.poll();
			if(visited.get(e.pos))	continue;
			visited.set(e.pos,true);
			u = e.pos;
			w = e.w;
			if(u == t)	return w;
			for(int i = 0;i < 4;i++) for(int j = 0;j < 2;j++) {
				v = next(u,j == 0,i);
				if(avail.get(v) && !visited.get(v))	pq.add(new Pair(w + 1,v));
			}
		}
		
		return -1;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),s,t,n;
		while(TC-- > 0) {
			avail.clear(); avail.flip(0,10000);
			s = getInt()*1000 + getInt()*100 + getInt()*10 + getInt();
			t = getInt()*1000 + getInt()*100 + getInt()*10 + getInt();
			n = getInt();
			while(n-- > 0)	avail.set(getInt()*1000 + getInt()*100 + getInt()*10 + getInt(),false);
			System.out.println(bfs(s,t));
		}
	}
	static class Pair implements Comparable<Pair> {
		public int w,pos;
		public Pair(int w,int pos) {
			this.w = w;
			this.pos = pos;
		}
		public int compareTo(Pair p) {return Integer.compare(w,p.w);}
	}
}
