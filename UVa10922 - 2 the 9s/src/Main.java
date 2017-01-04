import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		int ans;
		while(!(s = in.readLine()).equals("0")) {
			ans = calc(s);
			if(ans != -1)	out.write(s + " is a multiple of 9 and has 9-degree " + ans + ".\n");
			else	out.write(s + " is not a multiple of 9.\n");
		}
		out.flush();
	}
	static int calc(String s) {
		int sum = 0,round = 1;
		for(int i = 0;i < s.length();i++)	sum += s.charAt(i) - '0';
		if(sum % 9 != 0)	return -1;
		while(sum >= 10) {
			round++;
			int tmp = 0;
			while(sum != 0) {tmp += sum % 10; sum /= 10;}
			sum = tmp;
		}
		return round;
	}
}
