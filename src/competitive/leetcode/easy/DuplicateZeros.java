package competitive.leetcode.easy;


/**
 * https://leetcode.com/problems/duplicate-zeros/
 * Date: 02-06-2020
 */

public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros dz = new DuplicateZeros();
        dz.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        dz.duplicateZeros(new int[]{1, 2, 3});
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                i++;
                if (arr.length - i >= 0) System.arraycopy(arr, i - 1, arr, i, arr.length - i);

            }
        }
//        System.out.println(Arrays.toString(arr));
    }
}
