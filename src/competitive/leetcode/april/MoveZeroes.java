package competitive.leetcode.april;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(new int[]{0, 1, 0, 3, 12});
        mz.moveZeroes(new int[]{1, 0, 0, 3, 0, 12, 0});
    }

    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            if (zeroCount == 0) continue;
            int temp = nums[i];
            nums[i - zeroCount] = temp;
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
