package competitive.leetcode.april;

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(ms.maxSubArray(new int[]{-2}));
        System.out.println(ms.maxSubArray(new int[]{-2, 2}));
        System.out.println(ms.maxSubArray(new int[]{-2, -1}));
    }

//    public int maxSubArray(int[] nums) {
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum > maxSum) maxSum = sum;
//            }
//        }
//        return maxSum;
//    }

    public int maxSubArray(int[] a) {
        int n = a.length;
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curSum = curSum + a[i];
            max = Math.max(curSum, max);
            if (curSum < 0) curSum = 0;
        }
        return max;
    }
}
