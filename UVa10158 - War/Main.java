import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int c,x,y;
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)st.nval;
			ds_init(n*2);
			while((c = getInt()) != 0 | (x = getInt()) != 0 | (y = getInt()) != 0) {
				switch(c) {
				case 1: setFriends(x,y);			break;
				case 2: setFriends(x,twin(y));		break;
				case 3: checkFriends(x,y);			break;
				case 4: checkFriends(x,twin(y));	break;
				}
			}
		}
	}
	static int twin(int u) {return u < n ? (u+n):(u-n);}
	static int n;
	static void setFriends(int x,int y) {
		if(ds_find(x) == ds_find(twin(y)))	System.out.println(-1);
		else {ds_merge(x,y); ds_merge(twin(x),twin(y));}
	}
	static void checkFriends(int x,int y) {
		System.out.println(ds_find(x) == ds_find(y) ? 1:0);
	}
	static int[] ds_p = new int[20000],ds_r = new int[20000];
	static void ds_init(int n) {
		for(int i = 0;i < n;i++)	ds_p[i] = i;
		Arrays.fill(ds_r,0);
	}
	static int ds_find(int n) {
		int p = n,t;
		while(p != ds_p[p])	p = ds_p[p];
		while(n != ds_p[n]) {
			t = ds_p[n];
			ds_p[n] = p;
			n = t;
		}
		return p;
	}
	static void ds_merge(int a,int b) {
		a = ds_find(a); b = ds_find(b);
		if(a == b)	return;
		if(ds_r[a] == ds_r[b]) {ds_p[b] = a; ds_r[a]++;}
		else if(ds_r[a] > ds_r[b])	ds_p[b] = a;
		else	ds_p[a] = b;
	}
}
