import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ProbC {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("probc.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n = getInt(),k = getInt();
		Tree tree = new Tree();
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();
		while(n-- > 0) {
			list.clear();
			tree.clear();
			for(int i = 0;i < k;i++)	list.add(tree.insert(getInt()));
			Collections.sort(list);
			set.add(list.toString());
		}
		System.out.println(set.size());
	}
	static class Tree {
		static class Node {
			public int val;
			public Node left,right;
			public Node(int val) {this(val,null,null);}
			public Node(int val,Node left,Node right) {
				this.val = val;
				this.left = left;
				this.right = right;
			}
		}
		public Node root = null;
		public void clear() {root = null;}
		public String insert(int num) {
			if(root == null) {
				root = new Node(num);
				return "";
			}
			return insert(num,root,"");
		}
		private String insert(int num,Node node,String track) {
			if(node.val < num) {
				if(node.right == null) {
					node.right = new Node(num);
					return track + 1;
				}
				return insert(num,node.right,track + 1);
			}
			if(node.left == null) {
				node.left = new Node(num);
				return track + 0;
			}
			return insert(num,node.left,track + 0);
		}
	}
}
