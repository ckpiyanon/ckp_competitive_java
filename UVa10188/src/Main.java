import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb1,sb2;
		String s1,s2;
		String[] ans = {"Accepted","Presentation Error","Wrong Answer"};
		int n,m,status = 0;
		int TC = 0;
		while((n = Integer.parseInt(in.readLine())) != 0) {
			sb1 = new StringBuilder();
			sb2 = new StringBuilder();
			for(int i = 0;i < n;i++)	sb1.append(in.readLine() + "\n");
			m = Integer.parseInt(in.readLine());
			for(int i = 0;i < m;i++)	sb2.append(in.readLine() + "\n");
			s1 = sb1.toString(); s2 = sb2.toString();
			if(s1.equals(s2))	status = 0;
			else if(s1.replaceAll("[^0-9]","").equals(s2.replaceAll("[^0-9]","")))
				status = 1;
			else	status = 2;
			System.out.println("Run #" + ++TC + ": " + ans[status]);
		}
		in.close();
	}
}
