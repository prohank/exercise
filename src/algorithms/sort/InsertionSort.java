package algorithms.sort;

import java.util.Arrays;


/**
 * This sorting works by shifting all the greater numbers to the right of the number
 * being compared by one position so as to insert the smaller number before them in the array.
 */
public class InsertionSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{12, 11, 13, 5, 6, 7, 13, 0};
        int[] arr = new int[]{7, 1, 3, 2, 4, 5, 6};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int j = i - 1;
            while ((j >= 0) && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
            count++;
            System.out.println("Intermediate: " + Arrays.toString(arr));
        }
        System.out.println(count);
    }
}
