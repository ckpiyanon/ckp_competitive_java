import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] register = new int[10];
	static int[] ram = new int[1000];
	static int getNum(int n,int p) {
		for(int i = 0;i < p;i++)	n /= 10;
		return n % 10;
	}
	static int exec(int cmd) {
		System.out.printf("%03d\n",cmd);
		int d = getNum(cmd,1),s = getNum(cmd,0),n = s;
		switch(getNum(cmd,2)) {
		case 0: return register[s] == 0 ? 1:(1 + exec(register[d]));
		case 1: return (d == 0 && s == 0) ? 1:0;
		case 2: register[d] = s; break;
		case 3: register[d] = (register[d] + n) % 1000; break;
		case 4: register[d] = (register[d] * n) % 1000; break;
		case 5: register[d] = register[s]; break;
		case 6: register[d] = (register[d] + register[s]) % 1000; break;
		case 7: register[d] = (register[d] * register[s]) % 1000; break;
		case 8: register[d] = ram[register[s]]; break;
		case 9: ram[register[d]] = register[s]; break;
		}
		return 1;
	}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String sin;
		int TC = Integer.parseInt(in.readLine()),i,ans;
		in.readLine();
		while(TC-- > 0) {
			Arrays.fill(register,0);
			Arrays.fill(ram,0);
			i = ans = 0;
			while((sin = in.readLine()) != null && sin.length() > 0) {
				System.out.println(Arrays.toString(register));
				ram[i] = Integer.parseInt(sin);
				ans += exec(ram[i]);
				i++;
			}
			System.out.println(ans);
			if(TC > 0)	System.out.println();
		}
	}
}
