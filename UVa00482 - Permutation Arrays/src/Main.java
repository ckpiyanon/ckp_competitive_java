import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> indices = new ArrayList<Integer>();
		String[] list;
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			indices.clear();
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens())	indices.add(Integer.parseInt(st.nextToken()) - 1);
			st = new StringTokenizer(in.readLine());
			list = new String[indices.size()];
			for(int i = 0;i < indices.size();i++)	list[indices.get(i)] = st.nextToken();
			for(String s:list)	System.out.println(s);
			if(TC > 0)	System.out.println();
		}
	}
}
