package maths;


public class GCD {

    public static void main(String[] args) {
        System.out.println(GCD(37, 7));
        System.out.println(GCD(7, 37));
        System.out.println(GCD(10, 30));
        System.out.println(Math.ceil(-4.7));
        System.out.println(Math.floor(-4.7));
        System.out.println(Math.round(-4.7));
    }

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
}
