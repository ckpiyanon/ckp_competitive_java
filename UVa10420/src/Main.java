import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		ArrayList<String> arr = new ArrayList<String>();
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		String s1;
		while(n-- > 0) {
			st = new StringTokenizer(in.readLine());
			s1 = st.nextToken();
			if(map.get(s1) == null) {
				map.put(s1,1);
				arr.add(s1);
			}
			else
				map.put(s1,map.get(s1) + 1);
		}
		Collections.sort(arr);
		for(String s: arr) {
			out.write(s);
			out.write(" ");
			out.write(map.get(s).toString());
			out.write("\n");
		}
		out.flush();
	}
}
