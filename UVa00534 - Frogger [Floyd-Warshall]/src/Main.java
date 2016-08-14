import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static final double INF = 1000000.0;
	static double distance(double x1,double y1,double x2,double y2) {
		return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
	}
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		double[][] graph = new double[200][200];
		double[] x = new double[200],y = new double[200];
		int n,TC = 0;
		while((n = getInt()) != 0) {
			for(int i = 0;i < n;i++) {
				x[i] = getInt(); y[i] = getInt();
			}
			for(int i = 0;i < n;i++) for(int j = 0;j < n;j++)
				graph[i][j] = graph[j][i] = distance(x[i],y[i],x[j],y[j]);
			for(int k = 0;k < n;k++) for(int i = 0;i < n;i++) for(int j = 0;j < n;j++)
				graph[i][j] = Math.min(graph[i][j],Math.max(graph[i][k],graph[k][j]));
			System.out.println("Scenario #" + ++TC);
			System.out.printf("Frog Distance = %.3f\n\n",graph[0][1]);
		}
	}
}