import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<Integer>();
		int n;
		while((n = Integer.parseInt(in.readLine())) != 0) {
			q.clear();
			for(int i = 1;i <= n;i++)	q.add(i);
			out.write("Discarded cards:");
			while(q.size() > 1) {
				out.write(" " + q.poll());
				q.add(q.poll());
				if(q.size() > 1)	out.write(",");
			}
			out.write("\nRemaining card: " + q.poll() + "\n");
		}
		out.flush();
	}
}
