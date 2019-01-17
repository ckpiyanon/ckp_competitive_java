import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	static StreamTokenizer st;
	public static double getNum() throws Exception {st.nextToken(); return st.nval;}
	public static int getInt() throws Exception {return (int)getNum();}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));	
		ArrayList<Point> list = new ArrayList<Point>();
		ArrayList<Polygon> cities = new ArrayList<Polygon>();
		int n;
		while((n = getInt()) != -1) {
			list.clear();
			for(int i = 0;i < n;i++)	list.add(new Point(getInt(),getInt()));
			cities.add(new Polygon(list));
		}
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			Point p = new Point((int)st.nval,getInt());
			for(Polygon pol:cities)
				if(pol.contains(p)) {
					pol.turnOff();
					break;
				}
		}
		double area = 0;
		for(Polygon p:cities) if(!p.isOn())
			area += p.area;
		System.out.println(new DecimalFormat("0.00").format(area));
	}
	static List<Point> findConvex(ArrayList<Point> list) {
		Point tp = list.get(0);
		for(Point p:list)
			if(p.y < tp.y || p.y == tp.y && p.x < tp.x)
				tp = p;
		final Point cp = tp;
		Collections.sort(list,new Comparator<Point>() {
			public int compare(Point p,Point q) {
				if(cp.equals(p))	return -1;
				if(cp.equals(q))	return 1;
				double angleP = cp.angleTo(p);
				double angleQ = cp.angleTo(q);
				if(Math.abs(angleP - angleQ) < 1E-6) {
					return -Double.compare(cp.distanceTo(p),cp.distanceTo(q));
				}
				return Double.compare(angleP,angleQ);
			}
		});
		
		ArrayList<Point> stack = new ArrayList<Point>();
		stack.add(list.get(0)); stack.add(list.get(1));
		for(int i = 2;i <= list.size();i++) {
			Point p = list.get(i % list.size());
			Point q = list.get(i-1);
			if(Double.compare(cp.angleTo(p),cp.angleTo(q)) != 0) {
				while(stack.size() >= 2 && stack.get(stack.size() - 2).direction(stack.get(stack.size() - 1),p) <= 0)
					stack.remove(stack.size() - 1);
				stack.add(p);
			}
		}
		return stack;
	}
	static class Polygon {
		private List<Point> points;
		public final double area;
		private boolean status = true;
		public Polygon(List<Point> points) {
			this.points = findConvex(new ArrayList<Point>(points));
			points = this.points;
			double area = 0;
			for(int i = 0;i < points.size() - 1;i++) {
				area += points.get(i).x * points.get(i+1).y - points.get(i+1).x * points.get(i).y;
			}
			this.area = area / 2;
		}
		public boolean contains(Point p) {
			for(int i = 0;i < points.size() - 1;i++) {
				if(p.direction(points.get(i),points.get(i+1)) < 0)
					return false;
			}
			return true;
		}
		public void turnOff() {
			this.status = false;
		}
		public boolean isOn() {
			return status;
		}
	}
	static class Point {
		public final int x,y;
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
		public int direction(Point p,Point q) {
			return (p.x - x) * (q.y - y) - (p.y - y) * (q.x - x);
		}
	}
}
