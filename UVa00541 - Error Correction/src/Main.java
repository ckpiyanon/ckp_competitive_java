import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n,x = 0,y = 0,rO,cO;
		int[] row = new int[100],col = new int[100];
		while((n = getInt()) != 0) {
			Arrays.fill(row,0); Arrays.fill(col,0);
			for(int i = 0;i < n;i++)
				for(int j = 0;j < n;j++) {
					x = getInt();
					row[i] += x;
					col[j] += x;
				}
			rO = cO = 0;
			for(int i = 0;i < n;i++) {
				if(row[i] % 2 == 1) {
					rO++;
					x = i+1;
				}
				if(col[i] % 2 == 1) {
					cO++;
					y = i+1;
				}
			}
			if(rO == 0 && cO == 0)
				System.out.println("OK");
			else if(rO == 1 && cO == 1)
				System.out.println("Change bit (" + x + "," + y + ")");
			else
				System.out.println("Corrupt");
		}
	}
}
