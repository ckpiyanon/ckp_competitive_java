import java.io.File;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) throws Exception {
		Scanner sc1 = new Scanner(new File("out.txt"));
		Scanner sc2 = new Scanner(new File("ans.txt"));
		while(sc1.hasNext()) {
			String s1 = sc1.next();
			String s2 = sc2.next();
			if(!s1.equals(s2))
				System.out.println(s1 + "\t" + s2);
		}
		sc1.close();
		sc2.close();
	}
}
