import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.StreamTokenizer;

public class ProbD {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("inD.txt"));} catch(Exception e) {}
		try {System.setOut(new PrintStream(new FileOutputStream("outD.txt")));} catch(Exception e) {}
		PrintStream log = new PrintStream(new FileOutputStream("D.log"));
		long time = System.currentTimeMillis();
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		FenwickTree tree;
		int TC = getInt(),n,idx;
		int[] list = new int[100001];
		while(TC-- > 0) {
			n = getInt();
			tree = new FenwickTree(n);
			for(int i = 1;i <= n;i++)	tree.update(i,1);
			for(int i = 1;i <= n;i++)	list[getInt()] = i;
			for(int i = 1;i <= n;i++) {
				if(i > 1)	out.write(" ");
				if(i % 2 == 1) {
					idx = list[(i + 1) / 2];
					tree.update(idx,-1);
					out.write(String.valueOf(tree.rsq(idx)));
				}
				else {
					idx = list[n - ((i - 1) / 2)];
					tree.update(idx,-1);
					out.write(String.valueOf(tree.rsq(idx,n)));
				}
			}
			out.write("\n");
		}
		out.flush();
		log.print(System.currentTimeMillis() - time);
		log.close();
	}
	static class FenwickTree {
		public int[] tree;
		private int size;
		public FenwickTree(int size) {this.size = size; tree = new int[size + 1];}
		public int rsq(int n) {
			int sum = 0;
			for(int i = n;i != 0;i -= lsOne(i)) {
				sum += tree[i];
			}
			return sum;
		}
		public int rsq(int a,int b) {return rsq(b) - rsq(a-1);}
		public void update(int n,int v) {
			for(int i = n;i <= size;i += lsOne(i))	tree[i] += v;
		}
	}
	static int lsOne(int n) {return (n & (-n));}
}
