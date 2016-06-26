import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tester {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(new File("in.txt"));
		Scanner or = new Scanner(new File("test.txt"));
		StringTokenizer st;
		StringBuilder s1;
		String s2,o;
		int n = 0,x;
		while(sc.hasNext()) {
			if(n > 0)	or.nextLine();
			s1 = new StringBuilder(sc.nextLine());
			s2 = sc.nextLine();
			n = Integer.parseInt(or.nextLine());
			System.out.println(s1);
			System.out.println(s2);
			for(int i = 0;i < n;i++) {
				st = new StringTokenizer(or.nextLine(),"[ ,]");
				st.nextToken();
				o = st.nextToken();
				if(o.equals("Delete"))
					s1.deleteCharAt(Integer.parseInt(st.nextToken()) - 1);
				else if(o.equals("Insert"))
					s1.insert(Integer.parseInt(st.nextToken()) - 1,st.nextToken().charAt(0));
				else {
					x = Integer.parseInt(st.nextToken()) - 1;
					s1.deleteCharAt(x);
					s1.insert(x,st.nextToken().charAt(0));
				}
			}
			System.out.println(s1);
			System.out.println(s2);
			if(!s1.toString().equals(s2))	System.out.println(new String(new char[100]).replace('\0','*'));
			System.out.println();
		}
		sc.close();
		or.close();
	}
}
