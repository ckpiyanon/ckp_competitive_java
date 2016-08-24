import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.BitSet;
import java.util.PriorityQueue;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	
	static BitSet isPrime;
	static int[] tens = {1,10,100,1000};
	static int[] parent = new int[10000];
	
	static int inc(int n,int pos,int val) {
		int x = (n / tens[pos]) % 10;
		if(x + val < 0)	val += 10;
		if(x + val > 9)	val -= 10;
		return n + tens[pos]*val;
	}
	
	static int stp(int src,int des) {
		if(src == des)	return 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		BitSet visited = new BitSet(10000);
		Pair e;
		int u,v,w;
		pq.add(new Pair(src,0));
		while(!pq.isEmpty()) {
			e = pq.poll();
			u = e.k;
			w = e.v;
			if(visited.get(u))	continue;
			visited.set(u);
			for(int i = 0;i < 4;i++) for(int j = -9;j <= 9;j++) {
				if(j == 0)	continue;
				v = inc(u,i,j);
				if(visited.get(v) || !isPrime.get(v) || v < 1000)	continue;
				if(v == des)	return w + 1;
				pq.add(new Pair(v,w + 1));
			}
		}
		return -1;
	}
	
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		isPrime = new BitSet(10000);
		isPrime.set(2,10000);
		for(int i = 0;i < 10000;i++) if(isPrime.get(i)) for(int j = i + i;j < 10000;j += i)
			isPrime.set(j,false);
		int TC = getInt(),ans;
		while(TC-- > 0) {
			Arrays.fill(parent,0);
			ans = stp(getInt(),getInt());
			System.out.println(ans == -1 ? "Impossible":ans);
		}
	}
	static class Pair implements Comparable<Pair> {
		public int k,v;
		public Pair(int k,int v) {
			this.k = k;
			this.v = v;
		}
		public int compareTo(Pair p) {return v - p.v;}
	}
}
