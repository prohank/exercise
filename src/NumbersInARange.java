import java.util.Scanner;

public class NumbersInARange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();
        int a = sc.nextInt();

//        System.out.println(l + "" + r + "" + n + "" + a);

        int count = 0;
        for (int i = l; i <= r; i++) {
            int j = a;
            while (((i + j) <= r) && ((r - j) >= 0)) {
                count++;
                j++;

            }
        }

        System.out.println("Count:" + count);
    }
}
