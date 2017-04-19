import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int x,n,arr[] = new int[10000],left = 0,right = 0;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval;
			for(int i = 0;i < n;i++)	arr[i] = getInt();
			x = getInt();
			Arrays.sort(arr,0,n);
			for(int i = 0;i < n-1;i++) {
				if(Arrays.binarySearch(arr,i+1,n,x - arr[i]) > 0) {
					left = arr[i]; right = x - left;
				}
			}
			System.out.printf("Peter should buy books whose prices are %d and %d.\n\n",left,right);
		}
	}
}
