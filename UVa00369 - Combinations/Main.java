import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,m;
		while((n = getInt()) != 0 & (m = getInt()) != 0)
			out.write(n + " things taken " + m + " at a time is " + calc(n,m,n-m) + " exactly.\n");
		out.flush();
	}
	static int calc(int n,int m1,int m2) {
		int a = Math.min(m1,m2),b = Math.max(m1,m2),g;
		int[] na = new int[n - b];
		for(int i = 0;i < n - b;i++)	na[i] = b + 1 + i;
		for(int i = 2;i <= a;i++) {
			int x = i;
			for(int j = 0;j < n - b && x > 1;j++) {
				na[j] /= g = gcd(na[j],x); x /= g;
			}
		}
		int ret = 1;
		for(int x:na)	ret *= x;
		return ret;
	}
	static int[][] gcd = new int[101][101];
	static int gcd(int a,int b) {
		if(gcd[a][b] != 0)	return gcd[a][b];
		if(gcd[b][a] != 0)	return gcd[a][b] = gcd[b][a];
		if(a % b == 0)	return gcd[a][b] = gcd[b][a] = b;
		if(b % a == 0)	return gcd[a][b] = gcd[b][a] = a;
		return gcd[a][b] = gcd(b,a % b);
	}
}
