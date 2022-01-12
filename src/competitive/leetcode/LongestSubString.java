package competitive.leetcode;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Date: 12-01-2022
 */
public class LongestSubString {

    public static void main(String[] args) {
        LongestSubString lss = new LongestSubString();
        System.out.println(lss.longestSubstring("abcabcbb")); // 3
        System.out.println(lss.longestSubstring("bbbbb")); // 1
        System.out.println(lss.longestSubstring("pwwkew")); // 3
        System.out.println(lss.longestSubstring(" ")); // 1
        System.out.println(lss.longestSubstring("")); // 0
    }

    int longestSubstring(String s) {
        int longestSubstring = 1;
        if (s == null || s.isEmpty()) return 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String subString = "";
            for (int j = i; j < s.length() - 1; j++) {
                if (!s.substring(i, j + 1).contains(String.valueOf(s.charAt(j + 1)))) {
                    subString = s.substring(i, j + 2);
                } else break;
            }
            if (longestSubstring < subString.length()) longestSubstring = subString.length();
        }
        return longestSubstring;
    }
}
