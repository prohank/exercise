package competitive;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return the number of additions between two numbers such that they add up to target.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: 1
 * Explanation: Because 2+7 == 9, we return 1 pair.
 * Example 2:
 * Input: nums = [5,3,3,3,1], target = 6
 * Output: 3
 * Explanation: Pairs that add up to 6 => [5+1,3+3,3+3] => 3
 * <p>
 * Date: 10-02-2022
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] inputArr = new int[]{5, 3, 6, 8, 3, 3, -2, 0, 4, 2, 3};
        int[] inputArr2 = new int[]{5, 3, 6, 8, 3, 3, -2, 0, 4, 2, 3, 4, 2};
        int k = 6;
        System.out.println(TwoSum.findSumPairs(inputArr, k));
        System.out.println(TwoSum.findSumPairs(inputArr2, k));
        System.out.println(TwoSum.findSumPairsOptimized(inputArr, k));
        System.out.println(TwoSum.findSumPairsOptimized(inputArr2, k));
    }

    private static int findSumPairs(int[] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == 6) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int findSumPairsOptimized(int[] a, int k) {
        int count = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i : a) {
            int keyCount = numMap.getOrDefault(i, 0);
            keyCount++;
            numMap.put(i, keyCount);
        }
//        numMap.forEach((key, value) -> System.out.println("Before:" + key + ":" + value));
        for (int i = 0; i < a.length; i++) {
            int reqNum = k - a[i];
            if (numMap.containsKey(reqNum) && numMap.get(reqNum) > 0) {
                int numCount = numMap.get(reqNum);
                if(a[i] == reqNum){
                    count += numCount - 1;
                } else {
                    count += numCount;
                }
                numCount--;
                numMap.put(a[i], numCount);
            }
        }
//        numMap.forEach((key, value) -> System.out.println("After:" + key + ":" + value));

        return count;
    }
}
