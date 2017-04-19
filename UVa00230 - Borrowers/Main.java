import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		try {System.setIn(new FileInputStream("in.txt"));} catch(Exception e) {}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Book> list = new ArrayList<Book>();
		PriorityQueue<Book> pq = new PriorityQueue<Book>();
		StringBuilder sb; StringTokenizer st; String str;
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		BitSet borrowed;
		while(!(str = in.readLine()).equals("END")) {
			int i = 1; sb = new StringBuilder("\"");
			while(str.charAt(i) != '\"')	sb.append(str.charAt(i++));
			sb.append(str.charAt(i++)); i += 4;
			list.add(new Book(sb.toString(),str.substring(i)));
		}
		Collections.sort(list);
		borrowed = new BitSet(list.size());
		for(int i = 0;i < list.size();i++)	map.put(list.get(i).name,i);
		while(!(str = in.readLine()).equals("END")) {
			st = new StringTokenizer(str);
			switch(st.nextToken()) {
			case "BORROW": borrowed.set(map.get(st.nextToken("\n").trim())); break;
			case "RETURN": pq.add(list.get(map.get(st.nextToken("\n").trim()))); break;
			case "SHELVE": {
				while(!pq.isEmpty()) {
					Book b = pq.poll();
					int i = map.get(b.name) - 1;
					borrowed.set(i+1,false);
					while(i >= 0 && borrowed.get(i))	i--;
					out.write("Put " + b.name);
					if(i >= 0)	out.write(" after " + list.get(i).name + "\n");
					else	out.write(" first\n");
				}
				out.write("END\n");
			} break;
			}
		}
		out.flush();
	}
	static class Book implements Comparable<Book> {
		String name,author;
		Book(String n,String a) {name = n; author = a;}
		public int compareTo(Book b) {
			int ret = author.compareTo(b.author);
			if(ret == 0)	return name.compareTo(b.name);
			return ret;
		}
		public String toString() {return "{" + name + ":" + author + "}";}
	}
}
