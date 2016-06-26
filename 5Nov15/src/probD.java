import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.Arrays;

public class probD {
	static StreamTokenizer st;
	static final int M = 1000000007;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int TC = getInt(),TC_ = 0,n,x,in;
		int[] numFT,numFB;
		numFT = new int[100000];
		numFB = new int[100000];
		while(TC-- > 0) {
			n = getInt(); x = getInt();
			Arrays.fill(numFT,0);
			Arrays.fill(numFB,0);
			int tmp = x;
			for(int f = 2;f <= tmp;f++) {
				while(tmp % f == 0) {
					numFB[f]++;
					tmp /= f;
				}
			}
			for(int i = 0;i < numFB.length;i++)	numFB[i] *= n;
			while(n-- > 0) {
				in = getInt();
				tmp = x - in;
				if(tmp == 0) {
					numFT[0] = 1;
					continue;
				}
				for(int f = 2;f <= tmp;f++) {
					while(tmp % f == 0) {
						numFT[f]++;
						tmp /= f;
					}
				}
			}
			System.out.print("Case " + ++TC_ + ": ");
			if(numFT[0] > 0) {
				System.out.println(0);
			}
			else {
				int top = 1,bot = 1;
				for(int i = 2;i < 100000;i++) {
					if(numFT[i] > numFB[i]) {
						numFT[i] -= numFB[i];
						numFB[i] = 0;
					}
					else {
						numFB[i] -= numFT[i];
						numFT[i] = 0;
					}
					BigInteger bi = BigInteger.valueOf(i);
					if(numFT[i] > 0)
						top = ((top % M) * bi.modPow(BigInteger.valueOf(numFT[i]),
								BigInteger.valueOf(M)).intValue()) % M;
					if(numFB[i] > 0)
						bot = ((bot % M) * bi.modPow(BigInteger.valueOf(numFB[i]),
								BigInteger.valueOf(M)).intValue()) % M;
				}
				if(top == bot)	System.out.println(1);
				else	System.out.println(top + "/" + bot);
			}
		}
	}
}
