package competitive;

import java.util.HashMap;
import java.util.Map;


/**
 * Hackerrank - Falabella
 * String Reduction
 * Given a string, reduce it in such a way that all of its substrings are distinct.
 * To do so, you may delete any characters at any index. What is the minimum number of deletions needed?
 * Note: A substring is a contiguous group of 1 or more characters within a string.
 * Example s = "abab"
 * Substrings in s are { 'a', 'b', 'a', 'b', 'ab', 'ba', 'ab', 'aba', 'bab', 'abab'}.
 * By deleting one "a" and one "b", the string becomes "ab" or "ba" and all of its substrings are distinct.
 * This required 2 deletions.
 * Function Description
 * Complete the function getMinDeletions in the editor below.
 * getMinDeletions has the following parameter(s):
 * string s: the given string Returns:
 * int: the minimum number of deletions required
 * Constraints
 * • 1 <= n <= 10^5
 * Sample Case o
 * Sample Input For Custom Testing
 * "abcab"
 * Sample Output
 * 2
 */
public class StringReduction {

    public static void main(String[] args) {
        System.out.println(StringReduction.getMinDeletions("abab")); //2
        System.out.println(StringReduction.getMinDeletions("abcab")); //2
        System.out.println(StringReduction.getMinDeletions("abcabc")); //3
    }

    public static int getMinDeletions(String s) {
        int deletionCount = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int charCount = charMap.getOrDefault(c, 0);
            charCount++;
            charMap.put(c, charCount);
        }
        for (int i : charMap.values()) {
            if (i > 1) {
                deletionCount += (i - 1);
            }
        }

        return deletionCount;
    }
}
