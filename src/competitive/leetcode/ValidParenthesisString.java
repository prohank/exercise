package competitive.leetcode;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 * Date: 20-05-2020
 * This code is taken from Solutions.
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int leftBalance = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '*'))
                leftBalance++;
            else
                leftBalance--;

            if (leftBalance < 0) return false;
        }
        if (leftBalance == 0) return true;
        int rightBalance = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) == ')') || (s.charAt(i) == '*'))
                rightBalance++;
            else
                rightBalance--;

            if (rightBalance < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParenthesisString vps = new ValidParenthesisString();
        System.out.println(vps.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        System.out.println(vps.checkValidString(")"));
        System.out.println(vps.checkValidString("()"));
        System.out.println(vps.checkValidString(")("));
        System.out.println(vps.checkValidString(""));
        System.out.println(vps.checkValidString("*"));
        System.out.println(vps.checkValidString("(*)"));
        System.out.println(vps.checkValidString("(*))"));
        System.out.println(vps.checkValidString("*(*))"));
        System.out.println(vps.checkValidString("((*)"));
        System.out.println(vps.checkValidString("((*)*"));
        System.out.println(vps.checkValidString("(((*)*"));
        System.out.println(vps.checkValidString("(*(*)*"));
        System.out.println(vps.checkValidString("*(*)*)*"));
        System.out.println(vps.checkValidString("*(**)*)*"));
    }
}
