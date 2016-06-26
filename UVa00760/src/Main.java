import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int calc(String a,String b) {
		int i = 0,len = Math.min(a.length(),b.length());
		while(i < len && a.charAt(i) == b.charAt(i))	i++;
		return i;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s1,s2;
		Suffix sa1,sa2;
		ArrayList<Suffix> sa = new ArrayList<Suffix>();
		ArrayList<String> ans = new ArrayList<String>();
		int max;
		while(true) {
			s1 = in.readLine(); s2 = in.readLine();
			sa.clear();
			ans.clear();
			for(int i = 0;i <= s1.length();i++)
				sa.add(new Suffix(0,s1.substring(i)));
			for(int i = 0;i <= s2.length();i++)
				sa.add(new Suffix(1,s2.substring(i)));
			Collections.sort(sa);
			max = 0;
			for(int i = 0;i < sa.size();i++) {
				sa1 = sa.get(i);
				int j = i+1;
				while(j < sa.size() && sa.get(j).v == sa1.v)	j++;
				if(j == sa.size())	continue;
				sa2 = sa.get(j);
				s1 = sa1.s.substring(0,calc(sa1.s,sa2.s));
				if(s1.length() > max) {
					ans.clear();
					ans.add(s1);
					max = s1.length();
				}
				else if(s1.length() == max)	ans.add(s1);
			}
			Collections.sort(ans);
			if(max != 0)
				System.out.println(getAns(ans));
			else
				System.out.println("No common sequence.");
			if(in.readLine() == null)	break;
			System.out.println();
		}
	}
	static String getAns(ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0));
		for(int i = 1;i < list.size();i++)
			if(!list.get(i-1).equals(list.get(i)))
				sb.append("\n" + list.get(i));
		return sb.toString();
	}
	static class Suffix implements Comparable<Suffix> {
		public int v;
		public String s;
		public Suffix(int v,String s) {this.v = v; this.s = s;}
		public int compareTo(Suffix o) {return s.compareTo(o.s);}
	}
}
