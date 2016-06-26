import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		int cnum,prob,time;
		char v;
		String inp;
		StringTokenizer st;
		in.readLine();
		Contestant arr[] = new Contestant[100];
		while(TC-- > 0) {
			for(int i = 0;i < 100;i++)	arr[i] = new Contestant(i+1);
			while(true) {
				inp = in.readLine();
				if(inp == null || inp.length() == 0)	break;
				st = new StringTokenizer(inp);
				cnum = Integer.parseInt(st.nextToken()) - 1;
				prob = Integer.parseInt(st.nextToken()) - 1;
				time = Integer.parseInt(st.nextToken());
				v = st.nextToken().charAt(0);
				if(v == 'C' && !arr[cnum].solved[prob]) {
					arr[cnum].solved[prob] = true;
					arr[cnum].numSolved++;
					arr[cnum].time[prob] = time;
				}
				else if(v == 'I' && !arr[cnum].solved[prob]) {
					arr[cnum].penalty[prob]++;
				}
				arr[cnum].present = true;
			}
			Arrays.sort(arr);
			for(int i = 0;i < 100;i++)
				if(arr[i].present)	System.out.println(arr[i]);
			if(TC > 0)	System.out.println();
		}
	}
	static class Contestant implements Comparable<Contestant> {
		public int numSolved;
		public int[] time;
		public int[] penalty;
		public int num;
		public boolean solved[],present;
		public Contestant(int num) {
			numSolved = 0;
			time = new int[9];
			solved = new boolean[9];
			penalty = new int[9];
			present = false;
			this.num = num;
		}
		public int getTime() {
			int ans = 0;
			for(int i = 0;i < 9;i++) if(solved[i])
				ans += time[i] + 20*penalty[i];
			return ans;
		}
		public int compareTo(Contestant o) {
			if(numSolved == o.numSolved) {
				int t1 = getTime(),t2 = o.getTime();
				if(t1 == t2)	return num - o.num;
				return t1 - t2;
			}
			return o.numSolved - numSolved; // sort in decresing order
		}
		public String toString() {
			return num + " " + numSolved + " " + getTime();
		}
	}
}
