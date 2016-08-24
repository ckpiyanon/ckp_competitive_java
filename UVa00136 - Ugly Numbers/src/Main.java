import java.util.ArrayList;
import java.util.BitSet;

public class Main {
	public static void main(String args[]) throws Exception {
		BitSet isFrac = new BitSet(32000);
		ArrayList<Integer> prime = new ArrayList<Integer>();
		isFrac.set(0,1,true);
		for(int i = 2;i*i <= 1000000000;i++) {
			if(isFrac.get(i))	continue;
			prime.add(i);
			for(int j = i+i;j*j <= 1000000000;j += i)
				isFrac.set(j,true);
		}
		int n = 0,num;
		boolean ok = true;
		for(num = 1;n < 1500;num++) {
			for(int j = 3;prime.get(j)*prime.get(j) <= num && ok;j++) {
				if(num % prime.get(j) == 0)	ok = false;
			}
			if(ok)	n++;
			ok = true;
		}
		System.out.println(num);
		n = 0;
		for(num = 1;n < 1500;num++) {
			while(num % 2 == 0)	num /= 2;
			while(num % 3 == 0)	num /= 3;
			while(num % 5 == 0) num /= 5;
			if(num == 1)	n++;
		}
		System.out.println(num);
	}
}
