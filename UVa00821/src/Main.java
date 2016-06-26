import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		int x,y,arr[][] = new int[100][100],cases = 0,cnt;
		double sum;
		DecimalFormat dc = new DecimalFormat("0.000");
		HashSet<Integer> set = new HashSet<Integer>();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while((x = getInt()) != 0 & (y = getInt()) != 0) {
			set.clear();
			for(int i = 0;i < 100;i++)	Arrays.fill(arr[i],1000000);
			set.add(x-1);
			set.add(y-1);
			arr[x-1][y-1] = 1;
			while((x = getInt()) != 0 & (y = getInt()) != 0) {
				arr[x-1][y-1] = 1;
				set.add(x-1);
				set.add(y-1);
			}
			for(int i = 0;i < 100;i++) {
				if(!set.contains(i))	continue;
				for(int j = 0;j < 100;j++) {
					if(!set.contains(j))	continue;
					for(int k = 0;k < 100;k++) {
						if(!set.contains(k))	continue;
						arr[j][k] = Math.min(arr[j][k],arr[j][i] + arr[i][k]);
					}
				}
			}
			sum = cnt = 0;
			for(int i = 0;i < 100;i++) {
				if(!set.contains(i))	continue;
				for(int j = 0;j < 100;j++) {
					if(!set.contains(j) || arr[i][j] == 1000000 || i == j)	continue;
					sum += arr[i][j];
					cnt++;
				}
			}
			out.write("Case ");
			out.write(String.valueOf(++cases));
			out.write(": average length between pages = ");
			out.write(dc.format(sum / cnt));
			out.write(" clicks\n");
		}
		out.flush();
	}
}
