import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Map<String,Double> map = new TreeMap<String,Double>();
		DecimalFormat df = new DecimalFormat("0.0000");
		String s;
		int TC = Integer.parseInt(in.readLine());
		double qty;
		in.readLine();
		while(TC-- > 0) {
			map.clear();
			qty = 0;
			while((s = in.readLine()) != null && s.length() != 0) {
				Double x = map.get(s);
				if(x == null)	map.put(s,1.0);
				else		map.put(s,x+1);
				qty += 1;
			}
			for(Map.Entry<String,Double> entry:map.entrySet())
				System.out.println(entry.getKey() + " " + df.format(entry.getValue() * 100 / qty));
			if(TC > 0)	System.out.println();
		}
	}
}
