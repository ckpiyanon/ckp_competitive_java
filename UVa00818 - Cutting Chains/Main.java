import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	static StreamTokenizer st;
	static int getInt() throws Exception {st.nextToken(); return (int)st.nval;}
	static int n,openMask,visitMask;
	static int[] graph = new int[15];
	static boolean bitIsZero(int bits,int n) {return (bits & (1 << n)) == 0;}
	static int numOnes(int bits) {
		int num = 0;
		while(bits != 0) {num += bits & 1; bits = bits >> 1;}
		return num;
	}
	static boolean isRing(int s,int t) {
		if(!bitIsZero(visitMask,t))	return true;
		visitMask |= (1 << t);
		for(int i = 0;i < n;i++)
			if(bitIsZero(openMask,i) && !bitIsZero(graph[t],i) && i != s && isRing(t,i))	return true;
		return false;
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("in.txt"));
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int u,v,TC = 0,ans,numStrands,numOpen;
		boolean ok;
		while((n = getInt()) != 0) {
			Arrays.fill(graph,0);
			ans = n;
			while((u = getInt()) != -1 & (v = getInt()) != -1) {
				u--; v--; graph[u] |= (1 << v); graph[v] |= (1 << u);
			}
			for(openMask = 0;openMask < (1 << n);openMask++) {
				numOpen = numOnes(openMask);
				numStrands = 0;
				visitMask = 0;
				ok = true;
				for(int i = 0;i < n && ok;i++)	if(bitIsZero(openMask,i))
					ok = numOnes(graph[i]) - numOnes(openMask & graph[i]) <= 2;
				if(!ok)	continue;
				for(int i = 0;i < n && ok;i++) {
					if(bitIsZero(visitMask,i) && bitIsZero(openMask,i)) {
						// i is not visited and not opened
						numStrands++;
						ok = !isRing(-1,i);
					}
				}
				if(ok && numStrands - 1 <= numOpen)	ans = Math.min(ans,numOpen);
			}
			System.out.printf("Set %d: Minimum links to open is %d\n",++TC,ans);
		}
	}
}