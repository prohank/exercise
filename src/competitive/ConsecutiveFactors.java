package competitive;

import java.util.Scanner;

/**
 * Eagleview - Codility
 */
public class ConsecutiveFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int count = 0;
        for (int num = num1; num <= num2; num++) {
            for (int i = 1; i <= num; i++) {
                int factor = 0;
                if (num % i == 0) {
                    if (i != 1 && i != num) {
                        factor = num / i;
                        if (factor == i - 1) count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
