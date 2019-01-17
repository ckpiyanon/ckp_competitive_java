import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	static StreamTokenizer st;
	public static double getNum() throws Exception {st.nextToken(); return st.nval;}
	public static int getInt() throws Exception {return (int)getNum();}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));	
		ArrayList<Point> list = new ArrayList<Point>();
		int TC = getInt();
		System.out.println(TC);
		int n;
		while(TC-- > 0) {
			n = getInt(); list.clear();
			for(int i = 0;i < n;i++)	list.add(new Point(getInt(),getInt()));
			getInt();
			if(list.get(list.size() - 1).equals(list.get(0)))
				list.remove(list.size() - 1);
			Point tp = list.get(0);
			for(Point p:list) {
				if(p.y < tp.y || p.y == tp.y && p.x < tp.x)
					tp = p;
			}
			final Point cp = tp;
			Collections.sort(list,new Comparator<Point>() {
				public boolean equals(double a,double b) {
					return Math.abs(a - b) < 1E-6;
				}
				public int compare(Point p,Point q) {
					if(cp.equals(p))	return -1;
					if(cp.equals(q))	return 1;
					double angleP = cp.angleTo(p);
					double angleQ = cp.angleTo(q);
					if(equals(angleP,angleQ)) {
						return -Double.compare(cp.distanceTo(p),cp.distanceTo(q));
					}
					return Double.compare(angleP,angleQ);
				}
			});
			ArrayList<Point> stack = new ArrayList<Point>();
			stack.add(list.get(0));	stack.add(list.get(1));
			for(int i = 2;i <= list.size();i++) {
				Point p = list.get(i % list.size());
				Point q = list.get(i-1);
				if(Double.compare(cp.angleTo(p),cp.angleTo(q)) != 0) {
					while(stack.size() >= 2 && stack.get(stack.size() - 2).directionTo(stack.get(stack.size() - 1),p) <= 0)
						stack.remove(stack.size() - 1);
					stack.add(p);
				}
			}
			System.out.println(stack.size());
			System.out.println(stack.toString().replaceAll("[\\[\\]]","").replace(", ","\n"));
			if(TC > 0)	System.out.println("-1");
		}
	}
	static class Point {
		private int x,y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return x + " " + y;
		}
		public double distanceTo(Point p) {
			return Math.sqrt(Math.pow(x - p.x,2) + Math.pow(y - p.y,2));
		}
		public double angleTo(Point p) {
			return Math.atan2(p.y - y,p.x - x);
		}
		public boolean equals(Point p) {
			return x == p.x && y == p.y;
		}
		public int directionTo(Point p,Point q) {
			return (p.x - x) * (q.y - y) - (p.y - y) * (q.x - x);
		}
	}
}
