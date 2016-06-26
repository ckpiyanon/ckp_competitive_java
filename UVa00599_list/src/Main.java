import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Graph {
	public class Node {
		public char nodeName;
		public ArrayList<Node> edges;
		public Node(char nodeName) {
			this.nodeName = nodeName;
			edges = new ArrayList<Node>();
		}
		public void addEdge(Node n) {
			edges.add(n);
		}
	}
	public Node nodes[];
	public boolean v[];
	public Graph(ArrayList<String> edgeList) {
		nodes = new Node[26];
		for(int i = 0;i < 26;i++)
			nodes[i] = new Node((char)('A' + i));
		for(String s: edgeList) {
			this.addEdge(s.charAt(1),s.charAt(3));
			this.addEdge(s.charAt(3),s.charAt(1));
		}
		v = new boolean[26];
		for(int i = 0;i < 26;i++)
			v[i] = false;
	}
	public void addEdge(char a,char b) {
		nodes[(int)a-'A'].addEdge(nodes[(int)b - 'A']);
	}
	public int dfs(char start) {
		if(v[start - 'A'])
			return 0;
		int t,ans;
		v[start - 'A'] = true;
		ans = 1;
		for(Node n:nodes[start - 'A'].edges) {
			t = dfs(n.nodeName);
			ans += t;
		}
		return ans;
	}
	public int bfs(char start) {
		if(v[start - 'A'])
			return 0;
		int ans;
		Node t;
		Queue<Node> q = new LinkedList<Node>();
		q.add(nodes[start - 'A']);
		ans = 0;
		while(!q.isEmpty()) {
			t = q.poll();
			if(v[t.nodeName - 'A'])
				continue;
			v[t.nodeName - 'A'] = true;
			ans++;
			q.addAll(t.edges);
		}
		
		return ans;
	}
}

public class Main {
	static ArrayList<String> inputEdgeList = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		try {
			System.setIn(new FileInputStream(new File("input.txt")));
		}
		catch(FileNotFoundException e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String tmp;
		Graph graph;
		int tree,acorn,t,TC;
		StringTokenizer st;
		TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			inputEdgeList.clear();
			tmp = in.readLine();
			while(tmp.charAt(0) != '*') {
				inputEdgeList.add(tmp);
				tmp = in.readLine();
			}
			tmp = in.readLine();
			graph = new Graph(inputEdgeList);
			st = new StringTokenizer(tmp,",");
			tree = acorn = 0;
			while(st.hasMoreTokens()) {
				t = graph.dfs(st.nextToken().charAt(0));
//				t = graph.bfs(st.nextToken().charAt(0));
				if(t > 1)
					tree++;
				else if(t == 1)
					acorn++;
			}
			out.write("There are " + tree + " tree(s) and " + acorn + " acorn(s).\n");
		}
		out.flush();
		out.close();
	}

}
