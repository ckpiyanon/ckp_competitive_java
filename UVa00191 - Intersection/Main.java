import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int q = getInt();
		Point p1,p2,tl,br;
		while(q-- > 0) {
			p1 = new Point(getInt(),getInt());
			p2 = new Point(getInt(),getInt());
			tl = new Point(getInt(),getInt());
			br = new Point(getInt(),getInt());
			out.write((isInside(p1,tl,br) || isInside(p2,tl,br))
					? "T\n":"F\n");
		}
		out.flush();
	}
	static boolean isInside(Point p,Point topLeft,Point bottomRight) {
		return p.x >= topLeft.x && p.x <= bottomRight.x && p.y <= topLeft.y && p.y >= bottomRight.y;
	}
	static int orientation(Point p,Point q,Point r) {
		double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
		return val == 0 ? 0:val > 0 ? 1:2;
	}
	static boolean onSegment(Point p,Point q,Point r) {
		return q.x <= Math.max(p.x,r.x) && q.x >= Math.min(p.x,r.x) && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
	}
	static boolean intersect(Point p1,Point q1,Point p2,Point q2) {
		int o1 = orientation(p1,q1,p2);
		int o2 = orientation(p1,q1,q2);
		int o3 = orientation(p2,q2,p1);
		int o4 = orientation(p2,q2,q1);
		return	o1 != 0 && o2 != 0 && o3 != 0 && o4 != 0 && o1 != o2 && o3 != o4 ||
			o1 == 0 && onSegment(p1,p2,q1) || o2 == 0 && onSegment(p1,q2,q1) ||
			o3 == 0 && onSegment(p2,p1,q2) || o4 == 0 && onSegment(p2,q1,q2);
	}
	static class Point {
		int x,y;
		public Point(int xx,int yy) {x = xx; y = yy;}
	}
}
