import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> list = new ArrayList<Integer>(100);
	static void flip(int from,int to) {
		int tmp;
		while(from < to) {
			tmp = list.get(from);
			list.set(from,list.get(to));
			list.set(to,tmp);
			from++; to--;
		}
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		int max,midx;
		while((s = in.readLine()) != null) {
			System.out.println(s);
			st = new StringTokenizer(s); list.clear();
			while(st.hasMoreTokens())	list.add(Integer.parseInt(st.nextToken()));
			for(int i = list.size() - 1;i >= 0;i--) {
				max = list.get(i); midx = i;
				for(int j = i - 1;j >= 0;j--)
					if(list.get(j) > max) {
						max = list.get(j);
						midx = j;
					}
				if(midx == i)	continue;
				if(midx != 0) {
					System.out.print((list.size() - midx) + " ");
					flip(0,midx);
				}
				System.out.print((list.size() - i) + " ");
				flip(0,i);
			}
			
			System.out.println(0);
		}
	}
}
