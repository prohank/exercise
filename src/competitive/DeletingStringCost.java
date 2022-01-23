package competitive;

/**
 * Codility
 * You are given a string S. Deletion of the K-th letter of Scosts C[K]. After deleting a letter, the costs of deleting other letters do not change. For example, for S = "ab" and C = (1, 3), after deleting 'a', deletion of 'b' will still cost 3.
 * You want to delete some letters from S to obtain a string without two identical letters next to each other. What is the minimum total cost of deletions to achieve such a string?
 * Write a function:
 * class Solution { public int solution(String s, int[] C); }
 * that, given string S and array C of integers, both of length N, returns the minimum cost of all necessary deletions.
 * Examples:
 * 1. Given S = "abccbd" and C = [0, 1, 2, 3, 4, 5), the function should return 2. You can delete the first occurrence of 'c' to achieve "abcbd".
 * 2. Given S = "aabbcc" and C = [1, 2, 1, 2, 1, 2], the function should return 3. By deleting all letters with a cost of 1, you can achieve string "abc".
 * 3. Given S = "aaaa" and C = [3, 4, 5, 6], the function should return 12. You need to delete all but one letter 'a', and the lowest cost of deletions is 3+4+5=12.
 * 4. Given S = "ababa" and C = [10, 5, 10, 5, 10], the function should return 0. There is no need to delete any letter.
 * Write an efficient algorithm for the following assumptions:
 * • string S and array C have length equal to N;
 * • N is an integer within the range (1..100,000);
 * • string S consists only of lowercase letters ('a'-'Z');
 * • each element of array C is an integer within the range [0..1,000).
 */
public class DeletingStringCost {
    public static void main(String[] args) {
        DeletingStringCost dsc = new DeletingStringCost();
        System.out.println(dsc.solution("abccbd", new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println(dsc.solution("aabbcc", new int[]{1, 2, 1, 2, 1, 2}));
        System.out.println(dsc.solution("aaaa", new int[]{3, 4, 5, 6}));
        System.out.println(dsc.solution("aaaaba", new int[]{3, 4, 5, 6, 6, 6}));
        System.out.println(dsc.solution("aaabaa", new int[]{3, 4, 3, 5, 5, 6}));
        System.out.println(dsc.solution("ababa", new int[]{10, 5, 10, 5, 10}));
        System.out.println(dsc.solution("bb", new int[]{10, 5}));
        System.out.println(dsc.solution("b", new int[]{10}));
    }

    public int solution(String S, int[] C) {
        int result = 0;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                result += Math.min(C[i], C[i + 1]);
            }
        }
        return result;
    }
}
