import java.util.PriorityQueue;

public class Test {
	public static void main(String args[]) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i < 10;i++)	pq.add(i + 1);
		while(!pq.isEmpty())	System.out.println(pq.poll());
	}
}
