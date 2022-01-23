package competitive;

/**
 * Codility
 * You are given a string S, in which one letter occurs twice. Every other letter occurs at most once.
 * Write a function:
 * class Solution { public String solution (String s); }
 * which, given a string S, returns a single-character string: the letter that occurs twice.
 * Examples:
 * 1. Given S = "aba", the function should return "a".
 * 2. Given S = "zz", the function should return "z".
 * 3. Given S = "codility", the function should return "i".
 * Assume that:
 * • the length of the string S is within the range [2..27];
 * • string S consists only of lowercase letters (a-z);
 * • all letters in S are distinct except one, which occurs twice.
 */
public class DuplicateString {
    public static void main(String[] args) {
        DuplicateString ds = new DuplicateString();
        System.out.println(ds.solution("codility"));
        System.out.println(ds.solution("zz"));
        System.out.println(ds.solution("aba"));
        System.out.println(ds.solution("baa"));
    }
    public String solution(String S) {
        String result = "";
        for (int i = 0; i < S.length(); i++) {
            for (int j = i+1; j < S.length(); j++) {
                if(S.charAt(i) == S.charAt(j)){
                    return String.valueOf(S.charAt(i));
                }
            }
        }
        return result;
    }
}
