import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		Node node;
		int TC = getInt(),n,l,r,v;
		while(TC-- > 0) {
			n = getInt();
			node = new Node(0,100000,0);
			overlap = 0;
			while(n-- > 0) {
				l = getInt(); r = getInt(); v = getInt();
				node.replace(l,r,v);
			}
			System.out.println(overlap);
		}
	}
	static int overlap;
	static class Node {
		private int numLeft,numRight,val;
		private Node nodeLeft,nodeRight;
		public Node(int left,int right,int val) {
			this.numLeft = left;
			this.numRight = right;
			this.val = val;
			nodeLeft = nodeRight = null;
		}
		public void replace(int left,int right,int val) {
			if(nodeLeft == null && nodeRight == null && numLeft == left && numRight == right) {
				if(val <= this.val)	return;
				setVal(val);
			}
			else if(nodeLeft == null && nodeRight == null) {
				if(numLeft < left) {
					split(left);
					nodeRight.replace(left,right,val);
				}
				else if(numRight > right) {
					split(right);
					nodeLeft.replace(left,right,val);
				}
			}
			else {
				if(nodeLeft.numRight > left)
					nodeLeft.replace(left,Math.min(nodeLeft.numRight,right),val);
				if(nodeRight.numLeft < right)
					nodeRight.replace(Math.max(nodeRight.numLeft,left),right,val);
			}
		}
		public void setVal(int val) {
			this.val = val;
			overlap += numRight - numLeft;
		}
		public void split(int mid) {
			nodeLeft = new Node(numLeft,mid,val);
			nodeRight = new Node(mid,numRight,val);
		}
	}
}