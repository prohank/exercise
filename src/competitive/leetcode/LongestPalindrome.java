package competitive.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Date: 16-01-2022
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("HELLOMADAMHOWAREYOU")); //MADAM
        System.out.println(lp.longestPalindrome("babad")); //bab
        System.out.println(lp.longestPalindrome("cbbd")); //bb
        System.out.println(lp.longestPalindrome("a")); //a
        System.out.println(lp.longestPalindrome("ac")); //a
    }

    public String longestPalindrome(String str) {
        if (str == null || str.trim().isEmpty()) return "";
        return findPalindrome(str);
    }

    private String findPalindrome(String s) {
        String palindromeString;
        String longestPalindrome = "";
        int longestPalindromeLength = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char chi = s.charAt(i);
            for (int j = s.length() - 1; j >= i; j--) {
                char chj = s.charAt(j);
                if (chi == chj) {
                    palindromeString = checkPalindrome(s.substring(i, j + 1)) ? s.substring(i, j + 1) : null;
                    if (null != palindromeString) {
                        if (longestPalindromeLength < palindromeString.length()) {
                            longestPalindromeLength = palindromeString.length();
                            longestPalindrome = palindromeString;
                        }
                        break;
                    }
                }
            }

        }
        return longestPalindrome;
    }

    boolean checkPalindrome(String s) {
        for (int k = 0; k < s.length() / 2; k++) {
            if (s.charAt(k) != s.charAt(s.length() - k - 1)) {
                return false;
            }
        }
        return true;
    }

}
