import java.io.StreamTokenizer;

public class Main {
	StreamTokenizer st;
	int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	void run() throws Exception {
		
	}
	class Tree {
		public class Node {
			int l,r,num;
			Node nL,nR;
			public Node(int l,int r,int num) {
				this.l = l;
				this.r = r;
				this.num = num;
				nL = nR = null;
			}
			public void split(int point,int num,char flag) {
				if(flag == 'l') {
					nL = new Node(l,point,num);
					l = point + 1;
				}
				else if(flag == 'r') {
					nR = new Node(point,r,num);
					r = point - 1;
				}
			}
			public boolean isLeaf() {return nL == null && nR == null;}
			public boolean isFull() {return nL != null && nR != null;}
		}
		public Node root;
		public int numNode;
		public Tree(int l,int r) {
			root = new Node(l,r,0);
			numNode = 0;
		}
		public void split(Node node,int l,int r,int num) throws Exception {
			if(node.l > l || node.r < r) {
				throw new Exception("ERROR: out of range");
			}
			if(node.isLeaf()) {
				if(node.l == l && node.r == r)
					node.num = num;
				else if(node.l == l && node.r > r)
					node.split(r, num, 'l');
				else if(node.l > l && node.r == r)
					node.split(l, num, 'r');
				else {
					node.split(l, num, 'r');
					node.nR.split(r, num, 'l');
				}
				return;
			}
			if(node.isFull()) {
				Node nL = node.nL,nR = node.nR;
				if(nL.l <= l && r <= nL.r)
					split(nL,l,r,num);
				else if(nR.l <= l && nR.r <= r)
					split(nR,l,r,num);
				else if(nR.l <= r) {
					split(nL,l,nL.r,num);
					split(nR,nR.l,r,num);
				}
			}
		}
	}
}
