import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		int arr[] = new int[50];
		while(TC-- > 0) {
			int n = Integer.parseInt(in.readLine());
			Arrays.fill(arr,0);
			int i,j;
			for(i = 1;;i++) {
				for(j = 0;j < n;j++) {
					int root = (int)Math.sqrt(arr[j] + i);
					if(arr[j] == 0 || root * root == arr[j] + i) {
						arr[j] = i;	break;
					}
				}
				if(j >= n)	break;
			}
			System.out.println(i - 1);
		}
	}
}
