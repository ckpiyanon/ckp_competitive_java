import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StreamTokenizer st;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine()),yes,no;
		String inS;
		in.readLine();
		while(TC-- > 0) {
			MAXN = Integer.parseInt(in.readLine());
			yes = no = 0;
			uf_init();
			while((inS = in.readLine()) != null && inS.length() > 0) {
				StringTokenizer st = new StringTokenizer(inS);
				char c = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken()) - 1,y = Integer.parseInt(st.nextToken()) - 1;
				if(c == 'q') {
					if(find(x) == find(y))	yes++;
					else	no++;
				}
				else	merge(x,y);
			}
			System.out.println(yes + "," + no);
			if(TC > 0)	System.out.println();
		}
	}
	static int MAXN;
	static int[] parent = new int[1000],rank = new int[1000];
	static void uf_init() {
		for(int i = 0;i < MAXN;i++)	parent[i] = i;
		Arrays.fill(rank,0);
	}
	static int find(int u) {
		int p = u,t;
		while(p != parent[p])	p = parent[p];
		while(u != parent[u]) {
			t = parent[u];
			parent[u] = p;
			u = t;
		}
		return p;
	}
	static void merge(int a,int b) {
		a = find(a); b = find(b);
		if(a == b)	return;
		if(rank[a] == rank[b]) {
			parent[b] = a;
			rank[a]++;
		}
		else if(rank[a] > rank[b])	parent[b] = a;
		else	parent[a] = b;
	}
}
