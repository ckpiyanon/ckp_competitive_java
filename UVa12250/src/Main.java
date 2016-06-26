import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String,String> map = new HashMap<String,String>();
		String inp;
		int TC = 1;
		map.put("HELLO","ENGLISH");
		map.put("HOLA","SPANISH");
		map.put("HALLO","GERMAN");
		map.put("BONJOUR","FRENCH");
		map.put("CIAO","ITALIAN");
		map.put("ZDRAVSTVUJTE","RUSSIAN");
		while(true) {
			inp = in.readLine();
			if(inp.charAt(0) == '#')	break;
			inp = map.get(inp);
			out.write("Case ");
			out.write(String.valueOf(TC++));
			out.write(": ");
			out.write(inp == null ? "UNKNOWN":inp);
			out.write("\n");
		}
		out.flush();
	}
}
