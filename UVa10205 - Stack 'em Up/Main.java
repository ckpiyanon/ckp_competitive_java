import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static void init() {
		String values[] = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String suits[] = {"Clubs","Diamonds","Hearts","Spades"};
		for(int i = 0;i < 4;i++)	for(int j = 0;j < 13;j++)
			deck[i*13 + j] = values[j] + " of " + suits[i];
	}
	static String[] deck = new String[52];
	
	static BufferedReader br;
	static StringTokenizer st;
	static int getInt() throws Exception {
		while(st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		init();
		br = new BufferedReader(new InputStreamReader(System.in));
		String sin,list[],tmp[] = new String[52];
		int TC,n,arr[][] = new int[100][52];
		boolean first = true;
		TC = getInt();
		while(TC-- > 0) {
			n = getInt();
			for(int k = 0;k < n;k++)	for(int i = 0;i < 52;i++)	arr[k][i] = getInt() - 1;
			list = Arrays.copyOf(deck,52);
			while((sin = br.readLine()) != null && sin.length() > 0) {
				n = Integer.parseInt(sin) - 1;
				for(int i = 0;i < 52;i++)	tmp[i] = list[arr[n][i]];
				list = Arrays.copyOf(tmp,52);
			}
			if(!first)	System.out.println();
			first = false;
			for(int i = 0;i < 52;i++)	System.out.println(list[i]);
		}
	}
}
