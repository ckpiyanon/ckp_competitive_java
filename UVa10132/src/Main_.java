import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;

public class Main_ {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Iterator<String> it;
		int TC = Integer.parseInt(in.readLine()),sz,ans,t;
		String arr[] = new String[300];
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String ts,ansS = "";
		in.readLine();
		while(TC-- > 0) {
			sz = 0;
			map.clear();
			while((ts = in.readLine()) != null && ts.length() > 0)
				arr[sz++] = ts;
			for(int i = 0;i < sz;i++)
				for(int j = i+1;j < sz;j++) {
					ts = arr[i] + arr[j];
					if(map.get(ts) == null)	map.put(ts,1);
					else	map.put(ts,map.get(ts).intValue() + 1);
					ts = arr[j] + arr[i];
					if(map.get(ts) == null)	map.put(ts,1);
					else	map.put(ts,map.get(ts).intValue() + 1);
				}
			ans = 0;
			it = map.keySet().iterator();
			while(it.hasNext()) {
				ts = it.next();
				t = map.get(ts);
				if(ans < t) {
					ans = t;
					ansS = ts;
				}
			}
			out.write(ansS);
			out.write("\n");
			if(TC > 0)	out.write("\n");
		}
		out.flush();
	}
}
