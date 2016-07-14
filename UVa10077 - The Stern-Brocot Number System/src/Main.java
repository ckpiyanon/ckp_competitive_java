import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StringBuilder sb;
	static void play(Fraction left,Fraction right,Fraction n) {
		Fraction mid = left.add(right);
		if(mid.equals(n))	return;
		if(n.doubleValue() < mid.doubleValue()) {
			sb.append('L');
			play(left,mid,n);
		}
		else {
			sb.append('R');
			play(mid,right,n);
		}
	}
	static StreamTokenizer st;	
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int num,den;
		while(true) {
			num = getInt(); den = getInt();
			if(num == 1 && den == 1)	break;
			sb = new StringBuilder();
			play(Fraction.ZERO,Fraction.INF,new Fraction(num,den));
			System.out.println(sb);
		}
	}
	static class Fraction {
		public int num,den;
		public Fraction(int num,int den) {this.num = num; this.den = den;}
		public int getNum() {return num;}
		public int getDen() {return den;}
		public Fraction add(Fraction f) {return new Fraction(num + f.num,den + f.den);}
		public double doubleValue() {return (double)num / (double)den;}
		public boolean equals(Fraction f) {return num == f.num && den == f.den;}
		public static Fraction ZERO = new Fraction(0,1);
		public static Fraction INF = new Fraction(1,0);
	}
}
