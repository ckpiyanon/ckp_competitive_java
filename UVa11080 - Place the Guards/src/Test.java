import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test {
	public static void main(String args[]) throws Exception {
		BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream("out.txt")));
		BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream("ans.txt")));
		while(in1.ready() && in2.ready()) {
			if(!in1.readLine().equals(in2.readLine()))	System.out.println("---");
		}
	}
}
