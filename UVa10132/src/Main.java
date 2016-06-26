import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] arr = new String[300];
		ArrayList<String> arrL = new ArrayList<String>();
		String tmp;
		boolean found;
		int TC;
		int n,match;
		int tlen;
		TC = Integer.parseInt(in.readLine());
		in.readLine();
		while(TC-- > 0) {
			tmp = "";
			tlen = 0;
			n = 0;
			while(true) {
				arr[n] = in.readLine();
				if(arr[n] == null)
					break;
				if(arr[n].length() == 0)
					break;
				tlen += arr[n].length();
				n++;
			}
			tlen /= (n/2);
			arrL.clear();
			for(int i = 0;i < n;i++) {
				for(int j = i+1;j < n;j++) {
					if(arr[i].length() + arr[j].length() == tlen) {
						arrL.add(arr[i] + arr[j]);
						arrL.add(arr[j] + arr[i]);
					}
				}
			}
			Collections.sort(arrL);
			found = false;
			for(int i = 0;i < arrL.size() && !found;i++) {
				if(i > 0 && arrL.get(i-1).equals(arrL.get(i)))
					continue;
				tmp = arrL.get(i);
				match = 0;
				for(int j = i;j < arrL.size() && !found;j++) {
					if(tmp.equals(arrL.get(j)))
						match++;
					if(match == n/2)
						found = true;
				}
			}
			out.write(tmp + "\n");
			if(TC > 0)
				out.write("\n");
		}
		out.flush();
		in.close();
		out.close();
	}
}