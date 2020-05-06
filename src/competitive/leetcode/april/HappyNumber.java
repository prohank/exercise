package competitive.leetcode.april;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(19));
        System.out.println(hn.isHappy(99));
        System.out.println(hn.isHappy(1));
    }


    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> elements = new HashSet<>();
        return findIfHappy(n, elements);
    }

    private boolean findIfHappy(int n, Set<Integer> elements) {
        elements.add(n);
        int newNum = sumSquared(n);
//        System.out.println("Sum of digits squared of: " + n + " is " + newNum);
        if (elements.contains(newNum)) return false;
        else {
            elements.add(newNum);
            if (newNum == 1) return true;
            return findIfHappy(newNum, elements);
        }
    }

    private int sumSquared(int n) {
        int sum = 0;
        int digit;
        while (n > 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}

/* Other Solutions:
// 1 - start
private int digitSquareSum(int n) {

        int sum = 0, digit;
        while (n != 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;

        do {

            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);

        } while(slow != fast);

        return slow == 1 ? true : false;

    }
// 1 - end

// 2 - start
    public boolean isHappy(int n) {
        while(n != 1 && n != 4) {
            int cur = n;
            n = 0;
            while(cur > 0) {
                int d = cur % 10;
                n += d*d;
                cur /= 10;
            }
        }
        return n == 1;
    }
// 2 - end
 */