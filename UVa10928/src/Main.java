import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[1000],TC = Integer.parseInt(in.readLine()),n,min;
		boolean first;
		StringTokenizer st;
		while(TC-- > 0) {
			first = true;
			n = Integer.parseInt(in.readLine());
			min = Integer.MAX_VALUE;
			for(int i = 0;i < n;i++) {
				st = new StringTokenizer(in.readLine());
				min = Math.min(arr[i] = st.countTokens(),min);
			}
			for(int i = 0;i < n;i++) {
				if(arr[i] == min) {
					if(!first)	System.out.print(" ");
					first = false;
					System.out.print(i+1);
				}
			}
			System.out.println();
			if(TC > 0)	in.readLine();
		}
	}
}
