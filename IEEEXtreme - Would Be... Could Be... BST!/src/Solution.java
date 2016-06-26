import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Solution {
	StreamTokenizer st;
	int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	String getS() throws Exception {
		st.nextToken();
		return st.sval;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		new Solution().run();
	}
	void run() throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		ArrayList<Pair> arr = new ArrayList<>();
		DS set = new DS();
		int n;
		String s;
		while((n = getInt()) != 0) {
			arr.clear();
			for(int i = 0;i < n;i++)
				arr.add(new Pair(getS(),getS()));
			set.init(arr);
			s = "";
			if(!set.union())	s = "!BST";
			else {
				Collections.sort(arr);
				for(int i = 0;i < arr.size() && s.length() == 0;i++) {
					if(arr.get(i).x.compareTo(arr.get(i).y) >= 0)	s = "!BST";
					if(i == 0)	continue;
					if(arr.get(i-1).x.equals(arr.get(i).x))	s = "BST?";
				}
			}
			System.out.println(s.length() == 0 ? "BST!":s);
		}
	}
	class DS {
		public HashMap<String,String> map;
		public int size;
		public String find(String s) {
			String root = s,t;
			while(!root.equals(map.get(root)))	root = map.get(root);
			while(!s.equals(root)) {
				t = map.get(s);
				map.put(s,root);
				s = t;
			}
			return root;
		}
		public void merge(String s1,String s2) {
			String x = find(s1),y = find(s2);
			if(x.equals(y))	return;
			map.put(x,y);
			size--;
		}
		public boolean connected(String s1,String s2) {
			return find(s1).equals(find(s2));
		}
		boolean has(String s) {return map.get(s) != null;}
		public DS() {map = new HashMap<>();}
		public void init(List<Pair> list) {
			map.clear();
			size = 0;
			for(Pair pair: list) {
				if(!has(pair.x))	{size++; map.put(pair.x,pair.x);}
				if(!has(pair.y))	{size++; map.put(pair.y,pair.y);}
				merge(pair.x,pair.y);
			}
		}
		public boolean union() {
			boolean first = true;
			String s = "";
			Set<String> set = map.keySet();
			for(String it:set) {
				if(first) {first = false; s = find(it);}
				if(!s.equals(find(it)))	return false;
			}
			return true;
		}
	}
	class Pair implements Comparable<Pair> {
		public String x,y;
		public int compareTo(Pair o) {return x.compareTo(o.x);}
		public Pair(String x,String y) {this.x = x; this.y = y;}
	}
}
