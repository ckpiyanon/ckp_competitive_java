import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final double INF = 100000000.0;
	static double graph[][] = new double[250][250];
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		ArrayList<Point> list = new ArrayList<Point>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		BitSet visited = new BitSet(250);
		int TC = Integer.parseInt(in.readLine()),x,y,t1,t2;
		boolean first;
		double dist;
		in.readLine();
		while(TC-- > 0) {
			list.clear();
			for(double[] arr:graph) Arrays.fill(arr,INF);
			st = new StringTokenizer(in.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			while((s = in.readLine()) != null && s.length() > 0) {
				first = true;
				st = new StringTokenizer(s);
				while(st.hasMoreTokens()) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					if(x == -1 && y == -1)	break;
					list.add(new Point(x,y));
					if(!first) {
						t1 = list.size() - 1;
						t2 = t1 - 1;
						dist = Point.distance(list.get(t1),list.get(t2)) / (40.0 * 1000.0 / 60.0);
						graph[t1][t2] = graph[t2][t1] = Math.min(graph[t1][t2],dist);
					}
					first = false;
				}
			}
			for(int i = 0;i < list.size();i++)
				for(int j = 0;j < list.size();j++) {
					dist = Point.distance(list.get(i),list.get(j)) / (10.0 * 1000.0 / 60.0);
					graph[i][j] = graph[j][i] = Math.min(dist,graph[i][j]);
				}
			pq.clear();
			visited.clear();
			pq.add(new Edge(0,0));
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(visited.get(e.v))	continue;
				if(e.v == 1) {
					System.out.println(Math.round(e.w));
					break;
				}
				visited.set(e.v,true);
				for(int i = 0;i < list.size();i++) {
					if(visited.get(i))	continue;
					pq.add(new Edge(i,e.w + graph[e.v][i]));
				}
			}
			if(TC > 0)	System.out.println();
		}
	}
	static class Point {
		public int x,y;
		public Point(int x,int y) {this.x = x; this.y = y;}
		public static double distance(Point a,Point b) {
			return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
		}
	}
	static class Edge implements Comparable<Edge> {
		public int v;
		public double w;
		public Edge(int v,double w) {this.v = v; this.w = w;}
		public int compareTo(Edge e) {return Double.compare(w,e.w);}
	}
}
