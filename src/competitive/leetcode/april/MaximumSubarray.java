package competitive.leetcode.april;

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(ms.maxSubArray(new int[]{-2}));
        System.out.println(ms.maxSubArray(new int[]{-2, 2}));
        System.out.println(ms.maxSubArray(new int[]{-2, -1}));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) maxSum = sum;
            }
        }
        return maxSum;
    }


}

/* Other Solutions:
// 1 - Divide and Conquer - start
    public int maxSubArray(int[] nums) {
        return helper(nums,0,nums.length -1);
    }

    public int helper(int[] nums, int left, int right){
        if(left == right)
            return nums[left];

        int mid = (left + right)/2;
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid+1, right);

        int crossSum = crossSum(nums, mid, left, right);

        return Math.max(Math.max(leftSum,rightSum),crossSum);
    }

    public int crossSum(int[] nums, int mid, int left, int right){
        if(left == right)
            return nums[left];

        int leftSubSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i> left -1; i--){
            sum += nums[i];
            leftSubSum = Math.max(sum,leftSubSum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid+1 ; i < right+1; i++){
            sum += nums[i];
            rightSubSum = Math.max(rightSubSum,sum);
        }

        return leftSubSum + rightSubSum;
    }
// 1 - end

// 2 - start
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
// 2 - end
*/