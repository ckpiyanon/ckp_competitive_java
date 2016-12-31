import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] num = new int[10];
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			Arrays.fill(num,0);
			int n = Integer.parseInt(in.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i = 1;i <= n;i++)	sb.append(i);
			for(char ch:sb.toString().toCharArray())
				num[ch - '0']++;
			out.write(Arrays.toString(num).replace("[","").replace("]","").replace(",","") + "\n");
		}
		out.flush();
	}
}
