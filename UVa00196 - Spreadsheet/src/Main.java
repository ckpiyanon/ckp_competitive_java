import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk;
		int TC = Integer.parseInt(in.readLine());
		while(TC-- > 0) {
			stk = new StringTokenizer(in.readLine());
			m = Integer.parseInt(stk.nextToken());
			n = Integer.parseInt(stk.nextToken());
			for(int i = 0;i < n;i++) {
				stk = new StringTokenizer(in.readLine());
				for(int j = 0;j < m;j++) {
					String str = stk.nextToken();
					arr[i][j] = str.charAt(0) == '=' ? str:Integer.valueOf(str);
				}
			}
			for(int i = 0;i < n;i++) for(int j = 0;j < m;j++)
				out.write(getVal(i,j) + (j < m-1 ? " ":"\n"));
		}
		out.flush();
	}
	static int n,m;
	static Object arr[][] = new Object[999][18278];
	static int getR(String s) {
		int ret = 0;
		for(int i = 0;i < s.length();i++) if(Character.isDigit(s.charAt(i)))
			ret = ret * 10 + s.charAt(i) - '0';
		return ret - 1;
	}
	static int getC(String s) {
		int ret = 0;
		for(int i = 0;i < s.length() && Character.isAlphabetic(s.charAt(i));i++)
			ret = ret * 26 + s.charAt(i) - 'A' + 1;
		return ret - 1;
	}
	static Object getVal(int r,int c) {
		if(r >= n || c >= m)	return 0;
		if(arr[r][c] instanceof Integer)	return arr[r][c];
		StringTokenizer st = new StringTokenizer((String)arr[r][c],"=+");
		Integer sum = 0;
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			sum += (Integer)getVal(getR(str),getC(str));
		}
		return arr[r][c] = sum;
	}
}
