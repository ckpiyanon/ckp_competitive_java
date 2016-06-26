import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> inOrder,postOrder;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Node tree;
		inOrder = new ArrayList<Integer>();
		postOrder = new ArrayList<Integer>();
		while(in.ready()) {
			inOrder.clear(); postOrder.clear();
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens())	inOrder.add(Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens())	postOrder.add(Integer.parseInt(st.nextToken()));
			tree = buildTree(0,postOrder.size()-1,0,inOrder.size()-1);
			calc(tree);
			System.out.println(tree.ans);
		}
		in.close();
	}
	static Node buildTree(int bp,int ep,int bi,int ei) {
		int val = postOrder.get(ep);
		int p = inOrder.indexOf(val);
		int numR = ei - p;
		Node l = p > bi ? buildTree(bp,ep-numR-1,bi,p-1):null;
		Node r = p < ei ? buildTree(ep-numR,ep-1,p+1,ei):null;
		return new Node(val,l,r);
	}
	static void calc(Node tree) {
		Node l = tree.l,r = tree.r;
		if(l == null && r == null)	tree.ans = tree.val;
		else if(l == null) {
			calc(r);
			tree.sum += r.sum;
			tree.ans = r.ans;
		}
		else if(r == null) {
			calc(l);
			tree.sum += l.sum;
			tree.ans = l.ans;
		}
		else {
			calc(l); calc(r);
			if(l.sum == r.sum) {
				tree.sum += l.sum;
				tree.ans = Math.min(l.ans,r.ans);
			}
			else if(l.sum < r.sum) {
				tree.sum += l.sum;
				tree.ans = l.ans;
			}
			else {
				tree.sum += r.sum;
				tree.ans = r.ans;
			}
		}
	}
	static class Node {
		public int sum,val,ans;
		public Node l,r;
		public Node(int val,Node l,Node r) {
			this.val = this.sum = val;
			this.l = l;
			this.r = r;
		}
		public Node setL(Node l) {this.l = l; return this;}
		public Node setR(Node r) {this.r = r; return this;}
	}
}
