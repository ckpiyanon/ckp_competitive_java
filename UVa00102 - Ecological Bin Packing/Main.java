import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		int bins[] = new int[9];
		int seq[][] = {{0,2,1},{0,1,2},{2,0,1},{2,1,0},{1,0,2},{1,2,0}};
		int sum,total,minVal;
		String seqStr[] = {"BCG","BGC","CBG","CGB","GBC","GCB"}; // B = 0,G = 1,C = 2
		String ans = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String inputString;
		while((inputString = in.readLine()) != null) {
			st = new StringTokenizer(inputString);
			total = 0;
			for(int i = 0;i < 9;bins[i] = Integer.parseInt(st.nextToken()),total += bins[i++]);
			minVal = Integer.MAX_VALUE;
			for(int i = 0;i < 6;i++) {
				sum = total;
				for(int j = 0;j < 3;sum -= bins[seq[i][j] + j*3],j++);
				if(minVal > sum) {
					ans = seqStr[i];
					minVal = sum;
				}
			}
			out.write(ans + " " + minVal + "\n");
		}
		out.flush();
		out.close();
	}
}
