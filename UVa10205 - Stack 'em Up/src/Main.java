import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static String values[] = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	static String suits[] = {"Clubs","Diamonds","Hearts","Spades"};
	static String getName(int n) {return values[n % 13] + " of " + suits[n / 13];}
	
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sin;
		st = new StreamTokenizer(br);
		int TC,n,list[] = new int[52],tmp[] = new int[52],arr[][] = new int[100][52];
		boolean first = true;
		TC = getInt();
		while(TC-- > 0) {
			n = getInt();
			for(int k = 0;k < n;k++)	for(int i = 0;i < 52;i++)	arr[k][i] = getInt() - 1;
			br.readLine();
			for(int i = 0;i < 52;i++)	list[i] = i;
			while((sin = br.readLine()) != null && sin.length() > 0) {
				n = Integer.parseInt(sin) - 1;
				for(int i = 0;i < 52;i++)	tmp[i] = list[arr[n][i]];
				for(int i = 0;i < 52;i++)	list[i] = tmp[i];
			}
			if(!first)	System.out.println();
			first = false;
			for(int i = 0;i < 52;i++)	System.out.println(getName(list[i]));
		}
	}
}
