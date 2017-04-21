public class Main {
    public static void main(String args[]) throws Exception {
        int[] list = {0,1234,5678,9090};
        System.out.println("     0000 1234 5678 9090");
        for(int i = 0;i < 4;i++) {
            System.out.print(String.format("%04d ",list[i]));
            for(int j = 0;j < 4;j++) {
                System.out.print(String.format("%4d ",dist(list[i],list[j])));
                dist(list[i],list[j]);
            }
            System.out.println();
        }
    }
    static int dist(int a,int b) {
        char[] sa = String.format("%04d",a).toCharArray();
        char[] sb = String.format("%04d",b).toCharArray();
        int d = 0;
        for(int i = 0;i < 4;i++) {
            a = sa[i] - '0'; b = sb[i] - '0';
            if(a < b) {a ^= b; b ^= a; a ^= b;}
            d += Math.min(a - b,b + 10 - a);
        }
        return d;
    }
}