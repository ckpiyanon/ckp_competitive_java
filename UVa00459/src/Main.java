import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		UnionFind uf;
		int TC = Integer.parseInt(in.readLine());
		in.readLine();
		while(TC-- > 0) {
			uf = new UnionFind(in.readLine().charAt(0) - 'A' + 1);
			while((s = in.readLine()) != null && s.length() > 0)
				uf.merge(s.charAt(0) - 'A',s.charAt(1) - 'A');
			System.out.println(uf.size);
			if(TC > 0)	System.out.println();
		}
	}
	static class UnionFind {
		public int[] ds;
		public int size;
		public UnionFind(int n) {
			size = n;
			ds = new int[n];
			for(int i = 0;i < n;i++)	ds[i] = i;
		}
		public int find(int n) {
			int p = n,t;
			while(p != ds[p])	p = ds[p];
			while(n != p) {
				t = ds[n];
				ds[n] = p;
				n = t;
			}
			return p;
		}
		public void merge(int a,int b) {
			int x = find(a),y = find(b);
			if(x == y)	return;
			ds[x] = y; size--;
		}
	}
}
