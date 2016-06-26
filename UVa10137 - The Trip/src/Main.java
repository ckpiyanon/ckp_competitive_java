import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static BufferedReader br;
	static double getNum() throws Exception {return Double.parseDouble(br.readLine());}
	public static void main(String args[]) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Double> list = new ArrayList<Double>(1000);
		int n;
		double avg,x,y;
		while((n = (int)getNum()) != 0) {
			avg = 0;
			list.clear();
			for(int i = 0;i < n;i++) {
				list.add(x = getNum());
				avg += x;
			}
			avg = Math.round(avg * 100.0 / n) / 100.0;
			x = y = 0;
			for(Double d:list) {
				if(d > avg)	x += d - avg;
				if(d < avg)	y += avg - d;
			}
			System.out.printf("$%.2f\n",Math.min(x,y));
		}
	}
}
