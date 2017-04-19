import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws Exception {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int a,b,c,max = 0,min = 2000000000,curH;
		int arr[] = new int[10001];
		while(st.nextToken() != -1) {
			a = (int)st.nval;
			st.nextToken();
			b = (int)st.nval;
			st.nextToken();
			c = (int)st.nval;
			min = Math.min(min,a);
			max = Math.max(max,c);
			arr[a] = arr[c-1] = b;
		}
		for(int i = min;i < max;i++) {
			if(arr[i] == 0 && stack.isEmpty())
				continue;
			if(stack.isEmpty()) {
				stack.push(arr[i]);
				continue;
			}
			curH = stack.peek();
			if(curH == arr[i]) {
				stack.pop();
				continue;
			}
			if(arr[i] < curH && arr[i] != 0) {
				if(stack.indexOf(arr[i]) >= 0) {
					stack.remove(Integer.valueOf(arr[i]));
					arr[i] = curH;
					continue;
				}
				stack.pop();
				stack.push(arr[i]);
				stack.push(curH);
				arr[i] = curH;
				continue;
			}
			if(arr[i] == 0) {
				arr[i] = curH;
				continue;
			}
			if(arr[i] > curH) {
				stack.push(arr[i]);
				continue;
			}
		}
		for(int i = min;i <= max;i++)
			if(arr[i] != arr[i-1]) {
				out.write(String.valueOf(i));
				out.write(" ");
				out.write(String.valueOf(arr[i]));
				if(i < max)	out.write(" ");
			}
		out.flush();
	}
}
