import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String prob = sc.next();
		BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream("out" + prob + ".txt")));
		BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream("ans" + prob + ".txt")));
		int line = 1,error = 0;;
		while(in1.ready() && in2.ready()) {
			if(!in1.readLine().equals(in2.readLine())) {
				System.out.println(line);
				error++;
			}
			line++;
		}
		if(error == 0)	System.out.println("All correct");
		sc.close(); in1.close(); in2.close();
	}
}
