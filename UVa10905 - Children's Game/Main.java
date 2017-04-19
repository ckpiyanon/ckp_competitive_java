import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] list = new String[50];
		Comparator<String> cmp = new Comparator<String>() {
			public int compare(String s1,String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		};
		int n;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i < n;i++)	list[i] = st.nextToken();
			Arrays.sort(list,0,n,cmp);
			for(int i = 0;i < n;i++)	System.out.print(list[i]);
			System.out.println();
		}
	}
}
