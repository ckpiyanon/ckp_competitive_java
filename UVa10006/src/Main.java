import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> h = new HashSet<Integer>();
		boolean chk;
		h.add(561);
		h.add(1105);
		h.add(1729);
		h.add(2465);
		h.add(2821);
		h.add(6601);
		h.add(8911);
		h.add(10585);
		h.add(15841);
		h.add(29341);
		h.add(41041);
		h.add(46657);
		h.add(52633);
		h.add(62745);
		h.add(63973);
		int n;
		while((n = Integer.parseInt(bfr.readLine())) != 0) {
			chk = h.contains(n);
			if(chk)	bfw.write("The number ");
			bfw.write(String.valueOf(n));
			if(chk)	bfw.write(" is a Carmichael number.\n");
			else	bfw.write(" is normal.\n");
		}
		bfr.close();
		bfw.flush();
	}

}
