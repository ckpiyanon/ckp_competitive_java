import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static StreamTokenizer st;
    static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
    public static void main(String args[]) throws Exception {
        // try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = getInt(),n;
        ArrayList<Integer> list = new ArrayList<>(500);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        while(TC-- > 0) {
            list.clear();
            n = getInt();
            while(n-- > 0)  list.add(getInt());
            Arrays.fill(visited,false);
            pq.clear();
            int d = 0;
            int vv = 0,ww = Integer.MAX_VALUE;
            for(Integer v:list) if(ww > dist(0,v)) {
                ww = dist(0,v);
                vv = v;
            }
            pq.add(new Edge(vv,ww));
            while(!pq.isEmpty()) {
                Edge e = pq.poll();
                int u = e.v;
                if(!visited[u]) {
                    d += e.w;
                    visited[u] = true;
                    for(Integer v:list) if(!visited[v]) pq.add(new Edge(v,dist(u,v)));
                }
            }
            out.write(d + "\n");
        }
        out.flush();
    }
    static class Edge implements Comparable<Edge> {
        public int v,w;
        public Edge(int vv,int ww) {v = vv; w = ww;}
        public int compareTo(Edge e) {return w - e.w;}
    }
    static int dist(int a,int b) {
        int[] sa = {a  / 1000,(a / 100) % 10,(a / 10) % 10,a % 10};
        int[] sb = {b  / 1000,(b / 100) % 10,(b / 10) % 10,b % 10};
        int d = 0;
        for(int i = 0;i < 4;i++) {
            a = sa[i]; b = sb[i];
            if(a < b) {a ^= b; b ^= a; a ^= b;}
            d += Math.min(a - b,b + 10 - a);
        }
        return d;
    }
    static boolean[] visited = new boolean[10000];
}