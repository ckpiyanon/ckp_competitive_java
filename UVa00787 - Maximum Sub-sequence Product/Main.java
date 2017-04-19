import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
	static StreamTokenizer st;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		ArrayList<BigInteger> arr = new ArrayList<BigInteger>();
		BigInteger prod,ans;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			arr.clear();
			while((long)st.nval != -999999) {
				arr.add(BigInteger.valueOf((long)st.nval));
				st.nextToken();
			}
			ans = arr.get(0);
			for(int i = 0;i < arr.size();i++) {
				prod = BigInteger.ONE;
				for(int j = i;j < arr.size();j++) {
					prod = prod.multiply(arr.get(j));
					ans = ans.max(prod);
				}
			}
			System.out.println(ans);
		}
	}
}
