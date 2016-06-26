import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static boolean isPrefix(String a,String b) {
		if(a.length() > b.length())	return false;
		for(int i = 0;i < a.length();i++)
			if(a.charAt(i) != b.charAt(i))	return false;
		return true;
	}
	static boolean hasPrefix(ArrayList<String> list) {
		for(int i = 0;i < list.size();i++)
			for(int j = 0;j < list.size();j++)
				if(i != j && isPrefix(list.get(i),list.get(j)))
					return true;
		return false;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<String>();
		String s;
		int TC = 0;
		while(in.ready()) {
			list.clear();
			while(true) {
				s = in.readLine();
				if(s.charAt(0) == '9')	break;
				list.add(s);
			}
			System.out.printf("Set %d is%s immediately decodable\n",++TC,hasPrefix(list) ? " not":"");
		}
	}
}
