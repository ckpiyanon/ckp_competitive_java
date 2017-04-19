import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] register = new int[10];
	static int[] ram = new int[1000];
	static int getNum(int n,int p) {
		for(int i = 0;i < p;i++)	n /= 10;
		return n % 10;
	}
	static boolean halt;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String sin;
		int TC = Integer.parseInt(in.readLine()),i,cmd,ans;
		in.readLine();
		while(TC-- > 0) {
			Arrays.fill(register,0);
			Arrays.fill(ram,0);
			halt = false;
			i = 0;
			while((sin = in.readLine()) != null && sin.length() > 0)
				ram[i++] = Integer.parseInt(sin);
			i = ans = 0;
			while(true) {
				cmd = ram[i];
//				System.out.println(Arrays.toString(register));
//				System.out.println(cmd);
				if(cmd == 100) {
					ans++;
					break;
				}
				else {
					int c = getNum(cmd,2),d = getNum(cmd,1),s = getNum(cmd,0);
					switch(c) {
					case 1: i++; continue;
					case 2: register[d] = s; break;
					case 3: register[d] = (register[d] + s) % 1000; break;
					case 4: register[d] = (register[d] * s) % 1000; break;
					case 5: register[d] = register[d] = register[s]; break;
					case 6: register[d] = (register[d] + register[s]) % 1000; break;
					case 7: register[d] = (register[d] * register[s]) % 1000; break;
					case 8: register[d] = ram[register[s]]; break;
					case 9: ram[register[s]] = register[d]; break;
					case 0: {
						if(register[s] != 0)	i = register[d] - 1;
					}
					}
					ans++;
					i++;
				}
			}
			System.out.println(ans);
			if(TC > 0)	System.out.println();
		}
	}
}
