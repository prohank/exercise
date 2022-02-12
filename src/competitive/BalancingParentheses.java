package competitive;

import java.util.Stack;

/**
 * Hackerrank - Falabella
 * Balancing Parentheses
 * Given a string that consists of left and right parentheses, '('. and ')',
 * balance the parentheses by inserting parentheses as necessary.
 * Determine the minimum number of characters that must be inserted.
 * Example s = '(()))
 * Insert 1 left parenthesis at the left end of the string to get '((()))'. The string is balanced after 1 insertion.
 * Constraints
 * • 1 <= length of <= 10^5
 * Sample Input
 * s = '()))'
 * Sample Output
 * Explanation
 * Insert a '(' 2 times at the beginning of the string to make it valid: '((()))'.
 */
public class BalancingParentheses {

    public static void main(String[] args) {
        System.out.println(BalancingParentheses.getMin("(())")); //0
        System.out.println(BalancingParentheses.getMin("(()")); //1
        System.out.println(BalancingParentheses.getMin("())")); //1
        System.out.println(BalancingParentheses.getMin("()))")); //2
        System.out.println(BalancingParentheses.getMin("()))(")); //3
    }

    public static int getMin(String s) {
        // Write your code here
        int balaceCount = 0;
        if(s == null || s.trim().isEmpty()) return 0;
        Stack<Character> parenthesesStack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c == '('){
                parenthesesStack.push(c);
            } else if(c == ')' && parenthesesStack.isEmpty()){
                balaceCount++;
            } else if(c == ')'){
                parenthesesStack.pop();
            }
        }
        if (!parenthesesStack.isEmpty()){
            balaceCount += parenthesesStack.size();
        }
        return balaceCount;
    }
}

