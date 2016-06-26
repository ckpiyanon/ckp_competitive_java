import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int cnt,insert,delete,arr[][];
	static char s1[],s2[];
	static BufferedWriter out;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream(new File("in.txt")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		int l1,l2;
		arr = new int[81][81];
		while(in.ready()) {
			if(s1 != null)	out.write("\n");
			l1 = (s1 = in.readLine().toCharArray()).length;
			l2 = (s2 = in.readLine().toCharArray()).length;
			for(int i = 0;i <= l1;i++)	arr[i][0] = i;
			for(int i = 0;i <= l2;i++)	arr[0][i] = i;
			for(int i = 1;i <= l1;i++) for(int j = 1;j <= l2;j++)
				arr[i][j] = s1[i-1] == s2[j-1] ? arr[i-1][j-1]:(Math.min(arr[i-1][j-1],Math.min(arr[i][j-1],arr[i-1][j])) + 1);
			cnt = insert = delete = 0;
			out.write(arr[l1][l2] + "\n");
			run(l1,l2);
		}
		out.flush();
	}
	static void run(int r,int c) throws Exception {
		if(arr[r][c] == 0)	return;
		char dir = 'M';
		if(r != 0 || c != 0) {
			if(r == 0)	dir = 'I';
			else if(c == 0)	dir = 'D';
			else {
				int t = Math.min(Math.min(arr[r-1][c],arr[r][c-1]),arr[r-1][c-1]);
				if(t == arr[r][c])	dir = 'M';
				else if(t == arr[r-1][c-1])	dir = 'R';
				else if(t == arr[r-1][c])	dir = 'D';
				else	dir = 'I';
			}
		}
		switch(dir) {
		case 'M':
			run(r-1,c-1);
			break;
		case 'R':
			run(r-1,c-1);
			out.write(++cnt + " Replace " + (r + insert - delete) + "," + s2[c-1] + "\n");
			break;
		case 'D':
			run(r-1,c);
			out.write(++cnt + " Delete " + (r + insert - delete) + "\n");
			delete++;
			break;
		case 'I':
			run(r,c-1);
			out.write(++cnt + " Insert " + (r + 1 + insert - delete) + "," + s2[c-1] + "\n");
			insert++;
			break;
		}
	}
}
