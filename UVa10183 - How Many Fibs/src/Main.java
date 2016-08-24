import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		BigInteger arr[] = new BigInteger[480],a,b;
		arr[0] = BigInteger.ONE;
		arr[1] = BigInteger.valueOf(2);
		for(int i = 2;i < 480;i++)	arr[i] = arr[i-1].add(arr[i-2]);
		int m,n;
		while(true) {
			st = new StringTokenizer(in.readLine());
			a = new BigInteger(st.nextToken()); b = new BigInteger(st.nextToken());
			if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO))	break;
			m = 0;
			while(arr[m].compareTo(a) < 0)	m++;
			n = m;
			while(arr[n].compareTo(b) <= 0)	n++;
			sb.append((n-m));
			sb.append('\n');
		}
		out.write(sb.toString().getBytes());
		out.flush();
		in.close();
		out.close();
	}
}
