import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static double getNum() throws Exception {st.nextToken(); return st.nval;}
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval;
			for(int i = 0;i <= 20;i++) for(int j = 0;j < 20;j++) for(int k = 0;k < 20;k++) {
				map[i][j][k] = 0.00; path[i][j][k] = -1;
			}
			for(int i = 0;i < n;i++) for(int j = 0;j < n;j++) {
				if(i == j)	map[0][i][j] = 1.00;
				else	map[0][i][j] = getNum();
				path[0][i][j] = i;
			}
			int len = -1,ans = -1;
			for(int l = 1;l < n && len == -1;l++) {
				for(int k = 0;k < n;k++)
					for(int i = 0;i < n;i++)
						for(int j = 0;j < n;j++) {
							double x = map[l-1][i][k] * map[0][k][j];
							if(x > map[l][i][j]) {map[l][i][j] = x; path[l][i][j] = k;}
						}
				for(int i = 0;i < n;i++) if(map[l][i][i] > 1.01) {len = l; ans = i; break;}
			}
			if(len >= 0) {
				out.write(String.valueOf(ans + 1));
				print(len,ans,ans);
				out.write("\n");
			}
			else	out.write("no arbitrage sequence exists\n");
		}
		out.flush();
	}
	static int n;
	static double map[][][] = new double[21][20][20];
	static int path[][][] = new int[21][20][20];
	static void print(int len,int s,int t) throws Exception {
		if(len >= 0) {
			print(len-1,s,path[len][s][t]);
			out.write(" " + (t + 1));
		}
	}
}