package competitive.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

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
        int longestSubstringLength = 1;
        if (s == null || s.isEmpty()) return 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int subStringLength = 0;
            for (int j = i; j < s.length() - 1; j++) {
                if (!s.substring(i, j + 1).contains(String.valueOf(s.charAt(j + 1)))) {
                    subStringLength = s.substring(i, j + 2).length();
                } else break;
            }
            if (longestSubstringLength < subStringLength) longestSubstringLength = subStringLength;
        }
        return longestSubstringLength;
    }

    /**
     * Other approach using HashSet
     * @param s
     * @return
     */
    int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
