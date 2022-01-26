package competitive;

import java.util.HashMap;
import java.util.Map;

/**
 * Hackerrank
 * 23/01/2022
 * A string s comprised of digits from 0 to 9 contains a perfect substring if all the elements within a substring occur exactly k times. Calculate the number of perfect substrings in s.
 * Example
 * s = 1102021222 k= 2 The 6 perfect substrings are:
 * 1. s[0:1] = 11
 * 2. s[0:5] = 110202
 * 3. s[1:6] = 102021
 * 4. s[2:5] = 0202
 * 5. S[7:8] = 22
 * 6. S[8:9] = 22
 * Function Description
 * Complete the function perfectSubstring in the editor below.
 * perfectSubstring has the following parameters:
 * str s: a string where the value of each element s[i] is described by the character at position i (where 0 si<n)
 * int k: an integer that denotes the required frequency of the substring
 * Output
 * int: an integer that represents the number of perfect substrings in the given string
 * Constraints
 * • 1 <= sizeof(s) <= 10^5
 * • 0 <= s[i] <= 9(where 0 <= i < n)
 * • 1 <= k <= 10^5
 */
public class PerfectSubstring {
    public static void main(String[] args) {
        System.out.println(PerfectSubstring.perfectSubstring("1020122", 2)); //2
        System.out.println(PerfectSubstring.perfectSubstring("1221221121", 3)); //3
        System.out.println(PerfectSubstring.perfectSubstring("1102021222", 2)); //6
        System.out.println(PerfectSubstring.perfectSubstring("aabbcc", 2)); //6

    }

    public static int perfectSubstring(String s, int k) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> freqMap = new HashMap<>();
            int j = i;
            while (j < s.length()) {
                char c = s.charAt(j);
                int charCount = freqMap.getOrDefault(c, 0);
                freqMap.put(c, charCount+1);
                j++;
                if (freqMap.size() * k == (j - i)) {
                    if (checkMap(freqMap, k)) {
                        totalCount++;
                    }
                }
            }
        }
        return totalCount;
    }

    private static boolean checkMap(Map<Character, Integer> freqMap, int k) {
        for (int count : freqMap.values()){
            if (count != k) {
                return false;
            }
        }
        return true;
    }
}
