import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static StreamTokenizer st;
    static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
    public static void main(String args[]) throws Exception {
        // try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int n,m,u,v,w;
        while((n = getInt()) != 0 | (m = getInt()) != 0) {
            while(graph.size() < n) graph.add(new ArrayList<>());
            for(ArrayList<Edge> each:graph)  each.clear();
            while(m-- > 0) {
                u = getInt(); v = getInt(); w = getInt();
                graph.get(u).add(new Edge(v,w));
                graph.get(v).add(new Edge(u,w));
            }
            for(int i = 0;i < n;i++)    visited[i] = false;
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            int d = 0;
            pq.add(new Edge(0,0));
            while(!pq.isEmpty()) {
                Edge e = pq.poll();
                if(!visited[e.v]) {
                    visited[e.v] = true;
                    d = Math.max(d,e.w);
                    for(Edge ed:graph.get(e.v)) pq.add(ed);
                }
            }
            for(int i = 0;i < n;i++) if(!visited[i]) d = 0;
            if(d == 0)  out.write("IMPOSSIBLE\n");
            else    out.write(d + "\n");
        }
        out.flush();
    }
    static boolean[] visited = new boolean[100000];
    static class Edge implements Comparable<Edge> {
        public int v,w;
        public Edge(int v,int w) {this.v = v; this.w = w;}
        public int compareTo(Edge e) {return w - e.w;}
    }
}