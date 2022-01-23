package competitive;

import java.util.Arrays;

/**
 * Codility
 * The following find_min function should return the smallest integer from a given array A.
 * int find min(int[] A) {
 * int ans = 0; for (int i = 1; i < A.length; i++) { if (ans > A[i]) {
 * ans = A[i];
 * return ans;
 * Unfortunately it is an incorrect implementation. In other words, when the function is called with certain parameters, it returns the wrong answer. Your task is to generate a counterexample, i.e. an array A consisting of N integers such that the find min function returns the wrong answer.
 * Write a function:
 * class Solution { public int[] solution (int n; }
 * that, given an integer N, returns an array A consisting of N integers which describes a counterexample.
 * Example:
 * Given N = 4, your function may return [4, 2, 4, 5). It is a counterexample, because calling the find min function with this array returns 0, but the correct answer is 2. Your function may also return another counterexample; for example, (10,567, 99, 456].
 * Assume that:
 * • N is an integer within the range (1..1,000).
 */
public class IncorrectMinFunction {
    public static void main(String[] args) {
        IncorrectMinFunction imf = new IncorrectMinFunction();
        System.out.println(Arrays.toString(imf.solution(1)));
    }
    public int[] solution(int N) {
        int[] result = new int[N];
        int starter = 5;
        for (int i = 0; i < N; i++) {
            result[i] = starter++;
        }
        return result;
    }
}
