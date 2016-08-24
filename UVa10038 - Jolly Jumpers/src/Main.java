import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.BitSet;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BitSet bitset = new BitSet(3000);
		int n,prev,next;
		boolean isjolly;
		while(true) {
			if(st.nextToken() == StreamTokenizer.TT_EOF)	break;
			n = (int)st.nval;
			bitset.clear();
			prev = getInt();
			for(int i = 1;i < n;i++) {
				next = getInt();
				bitset.set(Math.abs(next - prev),true);
				prev = next;
			}
			isjolly = true;
			for(int i = 1;i < n;i++)	isjolly &= bitset.get(i);
			System.out.println(isjolly ? "Jolly":"Not jolly");
		}
	}
}
