package competitive.leetcode;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * Date: 28-06-2020
 * <p>
 * Given an array of integers and an integer k, you need to find the
 * total number of continuous subarrays whose sum equals to k.
 * <p>
 * Below is a Brute force solution. Try to optimize it.
 */
public class SubarraySum {
    public static void main(String[] args) {
        SubarraySum ss = new SubarraySum();
        System.out.println(ss.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(ss.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(ss.subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(ss.subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
        System.out.println(ss.subarraySum(new int[]{28, 54, 7, -70, 22, 65, -6}, 100));
    }

    public int subarraySum(int[] nums, int k) {
        int subarrays = 0;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    subarrays++;
                }
            }
        }
        return subarrays;
    }
}
