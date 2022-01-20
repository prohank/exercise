package competitive.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Date: 27-05-2020
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        System.out.println(Arrays.toString(pes.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(pes.productExceptSelf(new int[]{5, 2, 3, 6, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] productArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
                product *= nums[i - 1];
            productArr[i] = product;
        }
        product = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j < nums.length - 1)
                product *= nums[j + 1];
            productArr[j] = product * productArr[j];
        }

        return productArr;
    }
}
