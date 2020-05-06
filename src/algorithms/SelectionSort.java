package algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7, 13, 0};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int j;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if( minIndex == i) break; //If minimum index is not changed then array is sorted and no more swapping is required

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println(i + " Intermediate: " + Arrays.toString(arr));
        }
    }
}
