import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> sums = new ArrayList<Integer>(1000000);
		int n,list[] = new int[1000],t = 0,x;
		while((n = Integer.parseInt(in.readLine())) != 0) {
			sums.clear();
			for(int i = 0;i < n;i++)	list[i] = Integer.parseInt(in.readLine());
			for(int i = 0;i < n;i++) for(int j = 0;j < n;j++) if(i != j)
				sums.add(list[i] + list[j]);
			Collections.sort(sums);
			out.write("Case " + ++t + ":\n");
			n = Integer.parseInt(in.readLine());
			while(n-- > 0) {
				x = Integer.parseInt(in.readLine());
				out.write("Closest sum to " + x + " is " + find(sums,x) + ".\n");
			}
		}
		out.flush();
	}
	static int find(ArrayList<Integer> list,int n) {
		int idx = Collections.binarySearch(list,n);
		if(idx >= 0)	return n;
		idx = Math.abs(idx) - 1;
		if(idx == 0)	return list.get(idx);
		if(idx == list.size())	return list.get(idx - 1);
		int h = list.get(idx),l = list.get(idx - 1);
		return h - n > n - l ? l:h;
	}
}
