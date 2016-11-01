import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	static Map<String,Integer> map = new TreeMap<String,Integer>();
	static int counter = 0;
	static void permute(int x,String s,int max) {
		if(s.length() == max)	map.put(s,++counter);
		else	while(x < 26)	permute(x+1,s + (char)(x++ + 'a'),max);
	}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		for(int i = 1;i <= 5;i++)	permute(0,"",i);
		while((s = in.readLine()) != null) {
			Integer ans = map.get(s);
			out.write(ans == null ? "0\n":ans + "\n");
		}
		out.flush();
	}
}
