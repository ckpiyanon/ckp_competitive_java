import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Check {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Problem: ");
		char ch = sc.next().charAt(0);
		String s1 = ch + "ans.txt";
		String s2 = ch + "output.txt";
		boolean accepted = true;
		sc.close();
		BufferedReader in1,in2;
		in1 = new BufferedReader(new InputStreamReader(new FileInputStream(s1)));
		in2 = new BufferedReader(new InputStreamReader(new FileInputStream(s2)));
		while((s1 = in1.readLine()) != null && (s2 = in2.readLine()) != null) {
			if(!s1.equals(s2)) {
				accepted = false;
				break;
			}
		}
		System.out.println(accepted ? "Accepted":"Wrong Answer");
		in1.close(); in2.close();
	}
}
