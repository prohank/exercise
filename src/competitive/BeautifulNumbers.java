package competitive;

/**
 * Hackerearth - Paypal
 * 26-02-2022
 * You are given two integers L and R. Your task is to determine the sum of all the beautiful numbers from the range (L, R).
 * A number represents a beautiful number if it satisfies the following condition:
 * • If the number becomes 1 at some point by replacing it repeatedly with the sum of
 * squares of its digits.
 * Note: If the number never becomes 1, then the provided number is not a beautiful number.
 * For further clarification, please refer to the explanation of the sample test case.
 * Example
 * Consider L=1, R = 2. You have to determine the sum of all the beautiful numbers from the range (L, R).
 * Here the answer is 1 as 2 is not a beautiful number.
 * Function description:
 * Complete the solve function provided in the editor.
 * This function takes the following 2 parameters and returns the sum of all the beautiful numbers from the range (L, R).
 * • L: Represents an integer denoting L
 * • R: Represents an integer denoting R
 * Input format
 * Note: This is the input format that you must use to provide custom input (available above the Compile and Test button).
 * • The first line contains an integer T denoting the number of test cases.
 * • The next T lines contain two integers L and R.
 * Output format
 * For each test case, print a value that represents the sum of the beautiful numbers in the range (L, R).
 * Note: You are required to print the answers for each test case in a new line.
 * Constraints
 * 1 <= T <= 10^6
 * 1<=L<=R <= 10^6
 * Code snippets (also called starter code/boilerplate code)
 * Sample input
 * 2
 * 31 32
 * 7 7
 * Sample output
 * 63
 * 7
 * Explanation
 * For the first test case, both 31 and 32 can be reduced to 1, therefore the output is 63.
 * For example:
 * • Replace 31 by 3^2 + 1^2 = 10
 * • Replace 10 by 1^2 + O^2 = 1
 *
 * Solution - Partially Accepted
 */
public class BeautifulNumbers {

    public static void main(String[] args) {
        System.out.println(solve(1, 2)); //1
        System.out.println(solve(7, 7)); //7
        System.out.println(solve(31, 32)); //63
        System.out.println(solve(1, 10)); //18
        System.out.println(solve(1, 1000000));
        System.out.println(solve(3, 2834)); //596941
    }

    static long solve(int l, int r) {
        // Your code goes here
        long result = 0;
        for (long i = l; i <= r; i++) {
            long squareSum = 0;
            squareSum = getSquareSum(squareSum, i);
            if (squareSum == 1) {
                result += i;
            }
        }
        return result;
    }

    private static long getSquareSum(long squareSum, long num) {
        if(num == 0){
            return 0;
        }
        while (num > 0) {
            long digit = num % 10;
            squareSum += digit * digit;
            num = num / 10;
        }
        if (squareSum == 1 || squareSum == 7) {
            return 1;
        } else if (squareSum / 10 == 0) {
            return 0;
        } else {
            return getSquareSum(0, squareSum);
        }
    }
}
