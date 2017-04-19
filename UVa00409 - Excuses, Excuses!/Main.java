import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
//	static int match(String w,String s,int start) {
//		int[] p = new int[w.length() + 1];
//		int i = 0,m = w.length(),n = s.length();
//		for(int j = 2;j <= m;j++) {
//			while(i > 0 && w.charAt(i) != w.charAt(j-1))	i = p[i];
//			if(w.charAt(i) == w.charAt(j-1))	i++;
//			p[j] = i;
//		}
//		i = 0;
//		for(int j = start+1;j <= n;j++) {
//			while(i > 0 && w.charAt(i) != s.charAt(j-1))	i = p[i];
//			if(w.charAt(i) == s.charAt(j-1))	i++;
//			if(i == m)	return j - m;
//		}
//		return -1;
//	}
//	static int count(String w,String s) {
//		int num = 0,idx = -1;
//		while((idx = match(w,s,idx+1)) >= 0)	num++;
//		return num;
//	}
	static int count(String s) {
		StringTokenizer st = new StringTokenizer(s,delim);
		int num = 0;
		while(st.hasMoreTokens())	if(wordList.contains(st.nextToken())) num++;
		return num;
	}
	static HashSet<String> wordList = new HashSet<String>();
	static String delim;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("in.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTok;
		String inp;
		int k,e,num,max,TC = 0;
		ArrayList<String> sentences = new ArrayList<String>();
		ArrayList<Integer> amount = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(char c = ' ';c < (char)256;c++)
			if(!Character.isAlphabetic(c))
				sb.append(c);
		delim = sb.toString();
		while((inp = in.readLine()) != null) {
			max = 0;
			strTok = new StringTokenizer(inp);
			k = Integer.parseInt(strTok.nextToken());
			e = Integer.parseInt(strTok.nextToken());
			wordList.clear(); sentences.clear(); amount.clear();
			while(k-- > 0)	wordList.add(in.readLine().toLowerCase());
			while(e-- > 0)	sentences.add(in.readLine());
			for(String s:sentences) {
				num = count(s.toLowerCase());
				max = Math.max(max,num);
				amount.add(num);
			}
			System.out.println("Excuse Set #" + ++TC);
			for(int i = 0;i < amount.size();i++)
				if(amount.get(i) == max)
					System.out.println(sentences.get(i));
			System.out.println();
		}
	}
}
