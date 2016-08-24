import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> ing = new HashMap<String,Integer>();
		ArrayList<Pair> cake = new ArrayList<Pair>();
		String title,cakename;
		StringTokenizer st;
		int m,n,b,TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			ing.clear(); cake.clear();
			title = in.readLine().toUpperCase();
			st = new StringTokenizer(in.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			while(m-- > 0) {
				st = new StringTokenizer(in.readLine());
				ing.put(st.nextToken(),Integer.parseInt(st.nextToken()));
			}
			while(n-- > 0) {
				cakename = in.readLine();
				m = Integer.parseInt(in.readLine());
				int price = 0;
				while(m-- > 0) {
					st = new StringTokenizer(in.readLine());
					price += ing.get(st.nextToken()) * Integer.parseInt(st.nextToken());
				}
				cake.add(new Pair(cakename,price));
			}
			Collections.sort(cake);
			System.out.println(title);
			n = 0;
			for(Pair p:cake) {
				if(p.n > b)	break;
				System.out.println(p.s);
				n++;
			}
			if(n == 0)	System.out.println("Too expensive!");
			System.out.println();
		}
	}
	static class Pair implements Comparable<Pair> {
		public String s;
		public int n;
		public Pair(String s,int n) {
			this.s = s;
			this.n = n;
		}
		public int compareTo(Pair p) {
			if(n == p.n)	return s.compareTo(p.s);
			return Integer.compare(n,p.n);
		}
	}
}
