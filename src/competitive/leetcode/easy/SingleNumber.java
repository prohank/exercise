package competitive.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/single-number/
 * Date: 06-05-2020
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(sn.singleNumber(new int[]{4, 2, 1, 1, 4}));
        System.out.println(sn.singleNumber(new int[]{2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                i++;
            } else return nums[i];
        }
        return nums[nums.length - 1];
    }
}
