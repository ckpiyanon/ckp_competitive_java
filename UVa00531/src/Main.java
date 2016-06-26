import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static BufferedWriter out;
	static int arr[][],sz1,sz2;
	static String[] a1 = new String[100],a2 = new String[100];
	static String getS() throws Exception {
		st.nextToken();
		return st.sval;
	}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		arr = new int[100][100];
		while(true) {
			sz1 = sz2 = 0;
			while((s = getS()) != null)	a1[sz1++] = s;
			if(sz1 == 0)	break;
			while((s = getS()) != null)	a2[sz2++] = s;
			for(int i = 1;i <= sz1;i++)	for(int j = 1;j <= sz2;j++)
				arr[i][j] = a1[i-1].equals(a2[j-1]) ? (1 + arr[i-1][j-1]) : Math.max(arr[i][j-1],arr[i-1][j]);
			run(sz1,sz2);
		}
		out.flush();
	}
	static void run(int r,int c) throws Exception {
		if(arr[r][c] == 0 || r == 0 || c == 0)	return;
		int t = arr[r][c];
		while(arr[r-1][c] == t)	r--;
		while(arr[r][c-1] == t)	c--;
		run(r-1,c-1);
		out.write(a1[r-1]);
		out.write((t == arr[sz1][sz2]) ? "\n":" ");
	}
}
