import java.util.Scanner;

public class probE {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int TC,a,b,c;
		TC = sc.nextInt();
		while(TC-- > 0) {
			a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt() * 2;
			if(c > a || c > b)	System.out.println("NO");
			else	System.out.println("YES");
		}
		sc.close();
	}
}
