import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] graph = new int[26][26];
		String s;
		while(in.ready()) {
			for(int i = 0;i < 26;i++)	Arrays.fill(graph[i],0);
			while(true) {
				s = in.readLine();
				if(s.equals("deadend"))	break;
			}
		}
	}
}
