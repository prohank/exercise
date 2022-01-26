package competitive;

/**
 * Hackerrank
 * 23/01/2022 - Solution tested with limited cases
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases. Hence we call 585 a double base palindrome number.
 * Write a program to find the sum of all double base palindrome numbers which are less than a given number.
 * (Starting from 1, including the given number).
 * As an example, if the given number is 5,
 * the double base palindromes less than or equal to 5 are 1 (binary 1), 3 (binary 11) and 5 (binary 101).
 * The sum is 1 + 3 + 5 = 9.
 * Please note that the palindromic number, in either base, may not include leading zeros.
 */
public class DoubleBasePalindromes {

    public static void main(String[] args) {
        System.out.println(DoubleBasePalindromes.getSumOfDoubleBasePalindromes(5)); //9
        System.out.println(DoubleBasePalindromes.getSumOfDoubleBasePalindromes(0)); //0
        System.out.println(DoubleBasePalindromes.getSumOfDoubleBasePalindromes(10)); //25
    }

    public static int getSumOfDoubleBasePalindromes(int maximum) {
        int sum = 0;
        int count = maximum;
        while (count >= 1) {
            if (checkPalindrome(count)) {
                sum += count;
            }
            count--;
        }
        return sum;
    }

    private static boolean checkPalindrome(int num) {
        String str = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder(str);
        String reversedString = sb.reverse().toString();
        return str.equals(reversedString);
    }
}