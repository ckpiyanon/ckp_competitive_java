import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ProbD {
	static int r,c;
	static int top(int i,int j) {return i*c + j;}
	static int bottom(int i,int j) {return top(i,j) + r*c;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("Dinput.txt"));} catch(Exception e) {}
		try {System.setOut(new PrintStream("Dans.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for(int x = 1;x <= TC;x++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
			char tbl[][] = new char[r][];
			int edges[][] = new int[r][c];
			for(int i = 0;i < r;i++)	tbl[i] = in.readLine().toCharArray();
			for(int i = 0;i < r;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0;j < c;j++)
					edges[i][j] = Integer.parseInt(st.nextToken());
			}
			DisjointSet ds = new DisjointSet(r*c*2);
			for(int i = 0;i < r;i++) {
				for(int j = 0;j < c;j++) {
					if(tbl[i][j] == '/') {
						if(j > 0) {
							if(tbl[i][j-1] == '\\')	ds.merge(top(i,j),top(i,j-1));
							if(tbl[i][j-1] == '/')	ds.merge(top(i,j),bottom(i,j-1));
						}
						if(j+1 < c) {
							if(tbl[i][j+1] == '\\')	ds.merge(bottom(i,j),bottom(i,j+1));
							if(tbl[i][j+1] == '/')	ds.merge(bottom(i,j),top(i,j+1));
						}
					}
					if(tbl[i][j] == '\\') {
						if(j > 0) {
							if(tbl[i][j-1] == '\\')	ds.merge(bottom(i,j),top(i,j-1));
							if(tbl[i][j-1] == '/')	ds.merge(bottom(i,j),bottom(i,j-1));
						}
						if(j+1 < c) {
							if(tbl[i][j+1] == '\\')	ds.merge(top(i,j),bottom(i,j+1));
							if(tbl[i][j+1] == '/')	ds.merge(top(i,j),top(i,j+1));
						}
					}
					if(i > 0)		ds.merge(top(i,j),bottom(i-1,j));
					if(i + 1 < r)	ds.merge(bottom(i,j),top(i+1,j));
				}
			}
			ArrayList<Edge> arr = new ArrayList<Edge>();
			for(int i = 0;i < r;i++) for(int j = 0;j < c;j++)
				arr.add(new Edge(top(i,j),bottom(i,j),edges[i][j]));
			Collections.sort(arr);
			int ans = 0;
			for(Edge e:arr) {
				if(ds.isSameSet(e.u,e.v))	continue;
				ans += e.w;
				ds.merge(e.u,e.v);
			}
			System.out.println("Case " + x + ": " + ans);
		}
	}
	static class Edge implements Comparable<Edge> {
		public int u,v,w;
		public Edge(int u,int v,int w) {this.u = u; this.v = v; this.w = w;}
		public int compareTo(Edge e) {return Integer.compare(w,e.w);}
	}
	static class DisjointSet {
		private int ds[],size;
		public DisjointSet(int n) {
			ds = new int[n];
			size = n;
			for(int i = 0;i < n;i++)	ds[i] = i;
		}
		public int find(int n) {
			int tmp,root = n;
			while(root != ds[root])	root = ds[root];
			while(n != root) {
				tmp = ds[n];
				ds[n] = root;
				n = tmp;
			}
			return root;
		}
		public void merge(int a,int b) {
			int x = find(a),y = find(b);
			if(x == y)	return;
			ds[x] = y;
			size--;
		}
		public boolean isSameSet(int a,int b) {return find(a) == find(b);}
		public int size() {return size;}
	}
}
