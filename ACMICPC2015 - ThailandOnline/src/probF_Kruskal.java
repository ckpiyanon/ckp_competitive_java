import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Collections;
import java.util.LinkedList;

public class probF_Kruskal {
	static class Edge implements Comparable<Edge> {
		public int x,y,w,c;
		public Edge(int x,int y,int w,int c) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.c = c;
		}
		public int compareTo(Edge a) {return this.w - a.w;}
	}
	static class DisjointSet {
		public int sz[],id[],numSet;
		public DisjointSet(int num) {
			sz = new int[num];
			id = new int[num];
			numSet = num;
			for(int i = 0;i < num;i++) {
				sz[i] = 1;
				id[i] = i;
			}
		}
		public int find(int p) {
			int root = p,newp;
			while(root != id[root])
				root = id[root];
			while(p != root) {
				newp = id[p];
				id[p] = root;
				p = newp;
			}
			return root;
		}
		public void merge(int x,int y) {
			x = find(x);
			y = find(y);
			if(sz[x] > sz[y]) {
				id[y] = x;
				sz[x] += sz[y];
			}
			else {
				id[x] = y;
				sz[y] += sz[x];
			}
		}
		public void clear() {
			for(int i = 0;i < numSet;i++) {
				sz[i] = 1;
				id[i] = i;
			}
		}
	}
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("probF.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		LinkedList<Edge> arr = new LinkedList<Edge>();
		DisjointSet set = new DisjointSet(100);
		int TC,N,ans,cost;
		TC = getInt();
		while(TC-- > 0) {
			N = getInt();
			arr.clear();
			for(int i = 0;i < N;i++)
				for(int j = 0;j < N;j++)
					arr.add(new Edge(i,j,getInt(),getInt()));
			Collections.sort(arr);
			set.clear();
			ans = cost = 0;
			for(Edge e:arr) {
				if(set.find(e.x) != set.find(e.y)) {
					ans += e.w;
					cost += e.c;
					set.merge(e.x,e.y);
				}
			}
			System.out.println(ans + " " + cost);
		}
	}
}
