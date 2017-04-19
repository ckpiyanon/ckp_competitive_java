import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static final int INF = 1000000;
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static String getString() throws Exception {st.nextToken(); return st.sval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int TC = getInt(),n,m,q,u,v,p;
		int[][] graph = new int[30][30];
		int[][] map = new int[26][26];
		out.write("SHIPPING ROUTES OUTPUT\n");
		for(int tc = 1;tc <= TC;tc++) {
			n = getInt(); m = getInt(); q = getInt();
			for(int i = 0;i < n;i++)	Arrays.fill(graph[i],INF);
			for(int i = 0;i < n;i++) {str = getString(); map[str.charAt(0) - 'A'][str.charAt(1) - 'A'] = i;}
			while(m-- > 0) {
				str = getString(); u = map[str.charAt(0) - 'A'][str.charAt(1) - 'A'];
				str = getString(); v = map[str.charAt(0) - 'A'][str.charAt(1) - 'A'];
				graph[u][v] = graph[v][u] = 1;
			}
			for(int k = 0;k < n;k++) for(int i = 0;i < n;i++) if(graph[i][k] != INF)
				for(int j = 0;j < n;j++) graph[i][j] = Math.min(graph[i][j],graph[i][k] + graph[k][j]);
			out.write("\nDATA SET  " + tc + "\n\n");
			while(q-- > 0) {
				p = getInt();
				str = getString(); u = map[str.charAt(0) - 'A'][str.charAt(1) - 'A'];
				str = getString(); v = map[str.charAt(0) - 'A'][str.charAt(1) - 'A'];
				if(graph[u][v] != INF)	out.write("$" + (100 * graph[u][v] * p) + "\n");
				else	out.write("NO SHIPMENT POSSIBLE\n");
			}
		}
		out.write("\nEND OF OUTPUT\n");
		out.flush();
	}
}
