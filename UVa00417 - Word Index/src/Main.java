import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	static void per(int x,int n,String str) {
		if(n == 0) {
			map.put(str,map.size() + 1);
			return;
		}
		for(int i = x;i < 26;i++)	per(i + 1,n - 1,str + (char)('a' + i));
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		Integer ans;
		for(int i = 1;i <= 5;i++)	per(0,i,"");
		while((s = in.readLine()) != null) {
			ans = map.get(s);
			out.write(ans == null ? "0":ans.toString());
			out.write('\n');
		}
		out.flush();
	}
}
