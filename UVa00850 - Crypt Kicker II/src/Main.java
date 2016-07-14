import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static char[] computeDecoder(ArrayList<String> list) {
		String original = "the quick brown fox jumps over the lazy dog";
		int i;
		for(String s:list) {
			if(original.length() != s.length())	continue;
			char[] decoder = new char[256];
			decoder[' '] = ' ';
			for(i = 0;i < s.length();i++) {
				if(
					(original.charAt(i) == ' ' && s.charAt(i) != ' ') || 
					(s.charAt(i) == ' ' && original.charAt(i) != ' ') ||
					(decoder[s.charAt(i)] != '\0' && decoder[s.charAt(i)] != original.charAt(i))
				)
					break;
				decoder[s.charAt(i)] = original.charAt(i);
			}
			if(i == original.length())	return decoder;
		}
		return null;
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<String>(100);
		String s;
		int TC = Integer.parseInt(in.readLine());
		in.readLine();
		while(TC-- > 0) {
			list.clear();
			while((s = in.readLine()) != null && s.length() > 0)	list.add(s);
			char[] decoder = computeDecoder(list);
			if(decoder == null)	System.out.println("No solution.");
			else for(String each:list) {
				for(char c:each.toCharArray())
					System.out.print(decoder[c]);
				System.out.println();
			}
			if(TC > 0)	System.out.println();
		}
	}
}
