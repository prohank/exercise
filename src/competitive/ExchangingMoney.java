package competitive;

import java.util.Scanner;

public class ExchangingMoney {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfDenom = sc.nextInt();
        int noOfQueries = sc.nextInt();
        long[] d = new long[noOfDenom];
        for (int i = 0; i < noOfDenom; i++) {
            d[i] = sc.nextLong();
        }
        long gcd = d[0];
        for (int i = 1; i < noOfDenom; i++) {
            gcd = gcd(gcd, d[i]);
            System.out.println("maths.GCD:" + i + ":" + gcd);
        }
        while (noOfQueries-- > 0) {
            long p = sc.nextLong();
            if (p % gcd == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
