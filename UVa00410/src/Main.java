import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int C,S,TC = 0;
		double AM;
		int[] arr = new int[50];
		boolean[] selected = new boolean[50];
		while(st.nextToken() != -1) {
			Arrays.fill(selected,false);
			C = (int)st.nval;
			S = getInt();
			AM = 0;
			for(int i = 0;i < S;i++) {
				arr[i] = getInt();
				AM += arr[i];
			}
			AM /= C;
			System.out.println("Set #" + ++TC);
			double imbalance = 0.0;
			int k = 0;
			for(int i = 0;i < S;i++) {
				if(selected[i])	continue;
				selected[i] = true;
				int sum = arr[i];
				System.out.print(" " + ++k + ":");
				int ti = -1;
				for(int j = i+1;j < S;j++) {
					if(selected[j])	continue;
					if(Math.abs(arr[i] + arr[j] - AM) < Math.abs(arr[i] + (ti == -1 ? 0:arr[ti]) - AM))
						ti = j;
				}
				System.out.println(" " + arr[i] + (ti == -1 ? "":(" " + arr[ti])));
				if(ti != -1) {
					sum += arr[ti];
					selected[ti] = true;
				}
				imbalance += Math.abs(sum - AM);
			}
			System.out.printf("IMBALANCE = %.5f\n\n",imbalance);
		}
	}
}
