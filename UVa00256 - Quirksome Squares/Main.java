import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String ans[] = {
				"00\n01\n81\n",
				"0000\n0001\n2025\n3025\n9801\n",
				"000000\n000001\n088209\n494209\n998001\n",
				"00000000\n00000001\n04941729\n07441984\n24502500\n25502500\n52881984\n60481729\n99980001\n"};
		int n;
		System.out.println(ans[3].length());
		while(in.ready()) {
			n = Integer.parseInt(in.readLine());
			out.write(ans[n/2 - 1]);
		}
		out.flush();
	}
}
