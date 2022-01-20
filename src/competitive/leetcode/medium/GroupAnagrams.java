package competitive.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/
 * Date: 08-05-2020
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(System.out::println);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sortedStrings = new HashMap<>();
        List<String> strings;
        for(String s: strs){
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String sortedString = String.valueOf(sorted);
            if(sortedStrings.containsKey(sortedString)){
                List<String> value = sortedStrings.get(sortedString);
                value.add(s);
                strings = value;
            } else {
                strings = new ArrayList<>();
                strings.add(s);
            }
            sortedStrings.put(sortedString,strings);
        }
        return new ArrayList<>(sortedStrings.values());
    }


//////////////////////////////////////////////////////////////////
    // Inefficient solution - Time limit exceeds
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> anagrams = new ArrayList<>();
//        Set<String> stringSet = new HashSet<>();
//        for (int i = 0; i < strs.length; i++) {
//            List<String> strings = new ArrayList<>();
//            String primary = null;
//            if (!stringSet.contains(strs[i])) {
//                for (int j = i; j < strs.length; j++) {
//                    if (strings.isEmpty()) {
//                        primary = strs[j];
//                        strings.add(strs[j]);
//                        stringSet.add(strs[j]);
//                    } else if (areAnagrams(primary, strs[j])) {
//                        strings.add(strs[j]);
//                        stringSet.add(strs[j]);
//                    }
//                }
//            }
//            if (!strings.isEmpty()) anagrams.add(strings);
//        }
//        return anagrams;
//    }
//
//    private boolean areAnagrams(String s1, String s2) {
//        if (s1 == null || s2 == null) return false;
//        char[] s1Arr = s1.toLowerCase().toCharArray(), s2Arr = s2.toLowerCase().toCharArray();
//        if (s1Arr.length != s2Arr.length)
//            return false;
//        int[] counts = new int[26]; // An array to hold the number of occurrences of each character
//        for (int i = 0; i < s1Arr.length; i++) {
//            counts[s1Arr[i] - 97]++;  // Increment the count of the character at i
//            counts[s2Arr[i] - 97]--;  // Decrement the count of the character at i
//        }
//        // If the strings are anagrams, the counts array will be full of zeros
//        for (int i = 0; i < 26; i++)
//            if (counts[i] != 0)
//                return false;
//        return true;
//    }
}
