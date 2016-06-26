import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Main {
	static StreamTokenizer st;
	static int getInt() {
		try {st.nextToken();} catch(Exception e) {}
		return (int)st.nval;
	}
	static Node buildTree() {
		int val = getInt();
		if(val == -1)	return null;
		return new Node(val).setL(buildTree()).setR(buildTree());
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		Node tree;
		int TC = 0;
		while((tree = buildTree()) != null) {
			tree.assignNum(-tree.assignNum(0));
			System.out.println("Case " + ++TC + ":");
			System.out.println(tree.calc(new ArrayList<Integer>()).toString().replaceAll("[\\[\\],]",""));
			System.out.println();
		}
	}
	static class Node {
		public int val,num;
		public Node l,r;
		public Node(int val) {
			this.val = val;
			this.l = this.r = null;
		}
		public Node setL(Node l) {this.l = l; return this;}
		public Node setR(Node r) {this.r = r; return this;}
		public int assignNum(int num) {
			int min = this.num = num;
			if(l != null)	min = Math.min(min,l.assignNum(num-1));
			if(r != null)	min = Math.min(min,r.assignNum(num+1));
			return min;
		}
		public ArrayList<Integer> calc(ArrayList<Integer> list) {
			while(list.size() <= num)	list.add(0);
			list.set(num,val + list.get(num));
			if(l != null)	l.calc(list);
			if(r != null)	r.calc(list);
			return list;
		}
	}
}
