import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	static StreamTokenizer st;
	static double getDouble() throws Exception {st.nextToken(); return st.nval;}
	static final double INF = 20000.0;
	static ArrayList<Point> list;
	static double find(int start,int end) {
		if(start == end || end - start == 1)	return INF;
		int mid = (start + end) / 2;
		double min = Math.min(find(start,mid),find(mid,end));
		double line = (list.get(mid-1).x + list.get(mid).x) / 2.0;
		double ans = INF;
		for(int i = mid-1;i >= start && list.get(i).x > line-min;i--) {
			for(int j = mid;j < end && list.get(j).x < line+min;j++) {
				ans = Math.min(ans,Point.distance(list.get(i),list.get(j)));
			}
		}
		return Math.min(min,ans);
	}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n; double ans;
		list = new ArrayList<Point>();
		while((n = (int)getDouble()) != 0) {
			list.clear();
			for(int i = 0;i < n;i++)	list.add(new Point(getDouble(),getDouble()));
			Collections.sort(list,new Comparator<Point>() {
				public int compare(Point a,Point b) {
					if(a.x == b.x)	return Double.compare(a.y,b.y);
					return Double.compare(a.x,b.x);
				}
			});
			ans = find(0,n);
			if(ans < 10000.0)	System.out.printf("%.4f\n",ans);
			else	System.out.println("INFINITY");
		}
	}
	static class Point {
		public double x,y;
		public Point(double x,double y) {this.x = x; this.y = y;}
		public static double distance(Point a,Point b) {return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));}
	}
}
