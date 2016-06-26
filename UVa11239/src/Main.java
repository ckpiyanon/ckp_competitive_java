import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Map<String,String> map = new HashMap<String,String>();
		Map<String,Integer> map2 = new HashMap<String,Integer>();
		Set<String> not = new HashSet<String>();
		String s1,s2;
		s1 = in.readLine();
		while(true) {
			if(s1.charAt(0) == '0')	break;
			map2.put(s1,0);
			while(Character.isLowerCase((s2 = in.readLine()).charAt(0)) && s2.charAt(0) != '1') {
				if(map.containsKey(s2) && !map.get(s2).equals(s1))	not.add(s2);
				map.put(s2,s1);
			}
			if(s2.charAt(0) != '1')	s1 = s2;
			else {
				for(Map.Entry<String,String> entry:map.entrySet()) {
					if(not.contains(entry.getKey()))	continue;
					Integer i = map2.get(entry.getValue());
					map2.put(entry.getValue(),i+1);
				}
				List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>();
				list.addAll(map2.entrySet());
				Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
					public int compare(Map.Entry<String,Integer> a,Map.Entry<String,Integer> b) {
						if(a.getValue() == b.getValue())	return a.getKey().compareTo(b.getKey());
						return b.getValue().compareTo(a.getValue());
					}
				});
				for(Map.Entry<String,Integer> entry:list)
					System.out.println(entry.getKey() + " " + entry.getValue());
				map.clear();
				map2.clear();
				not.clear();
				s1 = in.readLine();
			}
		}
	}
}
