import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static int size;
	static int[] data = new int[10010],l = new int[10010],r = new int[10010],result = new int[10010];
	public static void main(String args[]) throws Exception {
//		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		Arrays.fill(data,-1); Arrays.fill(l,-1); Arrays.fill(r,-1);
		size = 1;
		st.nextToken(); data[0] = (int)st.nval;
		while(st.nextToken() != StreamTokenizer.TT_EOF)	add(0,(int)st.nval);
		size = 0; getResult(0);
		for(int i = 0;i < size;i++)	System.out.println(result[i]);
	}
	static void getResult(int i) {
		if(l[i] != -1)	getResult(l[i]);
		if(r[i] != -1)	getResult(r[i]);
		result[size++] = data[i];
	}
	static void add(int i,int n) {
		if(n < data[i]) {
			if(l[i] == -1) {l[i] = size; data[size++] = n;}
			else	add(l[i],n);
		}
		else {
			if(r[i] == -1) {r[i] = size; data[size++] = n;}
			else	add(r[i],n);
		}
	}
}