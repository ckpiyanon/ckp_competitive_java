import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		int n; double l,w;
		ArrayList<Circle> list = new ArrayList<Circle>(10000);
		while((s = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			l = Double.parseDouble(st.nextToken());
			w = Double.parseDouble(st.nextToken());
			list.clear();
			while(n-- > 0) {
				st = new StringTokenizer(in.readLine());
				double c = Double.parseDouble(st.nextToken());
				double r = Double.parseDouble(st.nextToken());
				double x = Math.sqrt(r*r - ((w*w)/4.0));
				list.add(new Circle(c - x,c + x));
			}
			Collections.sort(list,new Comparator<Circle>() {
				public int compare(Circle a,Circle b) {return Double.compare(a.start,b.start);}
			});
			double start = 0.0,end = 0.0;
			int ans = 0, i = 0,j;
			while(i < list.size() && start < l) {
				j = i;
				while(j < list.size() && list.get(j).start <= start) {
					end = Math.max(end,list.get(j).end);
					j++;
				}
				if(j == i)	break;
				ans++;
				start = end;
				i = j;
			}
			if(end < l || ans == 0)	ans = -1;
			out.write(ans + "\n");
		}
		out.flush();
	}
	static class Circle {
		public final double start,end;
		public Circle(double start,double end) {this.start = start; this.end = end;}
	}
}