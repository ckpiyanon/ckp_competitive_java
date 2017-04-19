import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		Set<String> set = new TreeSet<String>();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine()),n;
		while(TC-- > 0) {
			n = Integer.parseInt(in.readLine());
			list1.clear(); list2.clear(); set.clear();
			for(int i = 0;i < n;i++)	list1.add(in.readLine());
			for(int i = 0;i < n;i++)	list2.add(in.readLine());
			for(int i = n-1,j = n-1;i >= 0 && j >= 0;) {
				if(list1.get(i).equals(list2.get(j))) {
					i--;
					j--;
				}
				else {
					set.add(list1.get(i));
					i--;
				}
			}
			for(int i = n-1;i >= 0;i--)	if(set.contains(list2.get(i)))
				System.out.println(list2.get(i));
			System.out.println();
		}
	}
}
