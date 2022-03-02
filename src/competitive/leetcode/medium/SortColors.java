package competitive.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * Date: 01-03-2022
 */
public class SortColors {

    public static void main(String[] args) {
        sort2Pass(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}); //[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
        sort1Pass(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}); //[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
    }

    static void sort2Pass(int[] arr) {
        int zeroCount = 0;
        int oneCount = 0;
        int secondCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
            if (arr[i] == 1) {
                oneCount++;
            }
            if (arr[i] == 2) {
                secondCount++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < zeroCount) arr[i] = 0;
            else if (i < zeroCount + oneCount) arr[i] = 1;
            else arr[i] = 2;
        }
        System.out.println("Sorting in 2 passes: "+Arrays.toString(arr));

    }

    static void sort1Pass(int[] arr) {
        int pointer0 = 0;
        int pointer2 = arr.length - 1;
        int index = 0;

        while (index <= pointer2) {
            if (arr[index] == 0) {
                arr[index] = arr[pointer0];
                arr[pointer0] = 0;
                pointer0++;
            }
            if (arr[index] == 2) {
                arr[index] = arr[pointer2];
                arr[pointer2] = 2;
                pointer2--;
                index--;
            }
            index++;
        }
        System.out.println("Sorting in 1 pass: "+Arrays.toString(arr));
    }
}