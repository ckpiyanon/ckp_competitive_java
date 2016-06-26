import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_ {
	static int numR,numC;
	static String tbl[] = new String[50];
	static int dr[] = { 1, 1, 1,-1,-1,-1, 0, 0};
	static int dc[] = { 1, 0,-1, 1, 0,-1, 1,-1};
	static int ans[] = {0,0};
	static void find(String s) {
		int nr,nc;
		for(int i = 0;i < numR;i++) {
			for(int j = 0;j < numC;j++) {
				ans[0] = i + 1;
				ans[1] = j + 1;
				for(int k = 0;k < 8;k++) {
					for(int l = 0;l < s.length();l++) {
						nr = i + dr[k]*l;
						nc = j + dc[k]*l;
						if(nr < 0 || nr >= numR || nc < 0 || nc >= numC || s.charAt(l) != tbl[nr].charAt(nc))
							break;
						if(l == s.length() - 1)
							return;
					}
				}
			}
		}
	}
	public static void main(String args[]) throws IOException {
		try {
			System.setIn(new FileInputStream(new File("in.txt")));
		} catch(FileNotFoundException e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String inS;
		int TC = Integer.parseInt(in.readLine());
		int q;
		while(TC-- > 0) {
			in.readLine();
			st = new StringTokenizer(in.readLine());
			numR = Integer.parseInt(st.nextToken());
			numC = Integer.parseInt(st.nextToken());
			for(int i = 0;i < numR;i++)
				tbl[i] = in.readLine().toUpperCase();
			q = Integer.parseInt(in.readLine());
			while(q-- > 0) {
				inS = in.readLine().toUpperCase();
				find(inS);
				out.write(ans[0] + " " + ans[1] + "\n");
			}
			if(TC > 0)
				out.write("\n");
		}
		out.flush();
		in.close();
		out.close();
	}
}
