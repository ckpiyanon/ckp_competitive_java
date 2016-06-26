import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Stack;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StreamTokenizer(in);
		Stack<Integer> stack = new Stack<Integer>();
		int n,x,nN,arr[] = new int[1000];
		while((nN = getInt()) != 0) {
			while(true) {
				if((arr[0] = getInt()) == 0)	break;
				for(int i = 1;i < nN;i++)	arr[i] = getInt();
				n = (x = 0) + 1;
				stack.clear();
				while(n <= nN) {
					stack.add(n++);
					while(!stack.isEmpty() && stack.peek() == arr[x]) {
						stack.pop();
						x++;
						if(x >= nN)	break;
					}
				}
				out.write(stack.isEmpty() ? "Yes\n":"No\n");
			}
			out.write("\n");
		}
		out.flush();
	}
}
