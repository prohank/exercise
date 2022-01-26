package competitive;

import java.util.HashSet;
import java.util.Set;

/**
 * Hackerrank
 * 23/01/2022 - Solution tested with limited cases
 * Consider the fraction, n/d, where n and d are positive integers.
 * If n< d and HCF(n,d) = 1, it is called a reduced proper fraction. (HCF = Highest Common Factor).
 * If we list the set of reduced proper fractions for ds 8 in ascending order of size, we get:
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * It can be seen that there are 21 elements in this set.
 * Write a program to count the number of proper fractions for a given number d.
 */
public class CountingFractions {
    public static void main(String[] args) {

        System.out.println(CountingFractions.countProperFractions(8)); //21
        System.out.println(CountingFractions.countProperFractions(2)); //1
    }

    public static int countProperFractions(int max_d) {
        Set<String> fractions = new HashSet<>();
        for (double i = 2; i <= max_d; i++) {
            for (double j = 1; j <= i; j++) {
                double fraction = j / i;
                if (fraction != 1)
                    fractions.add("" + fraction);
            }
        }
        return fractions.size();
    }
}
