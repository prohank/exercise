package algorithms.sort;

import java.util.Arrays;

/**
 * In this sorting a pivot is selected on which the comparison of the numbers is based.
 *
 * Position of the pivot is not important but should be fixed throughout the program.
 *
 * Objective is to have all smaller numbers than the pivot on left and all greater numbers to the right and do it
 * till all the numbers are sorted.
 *
 * In the given program comparison starts from both the ends (left and right).
 * If the number to the left is greater than the pivot and number to the right is smaller then the two
 * numbers are swapped.
 * This continues till both left and right indices cross each other.
 * It gives us two sub arrays with the left to pivot containing all smaller numbers
 * and to the right will all bigger numbers than itself.
 * But these numbers are still unsorted so above program will again repeat for these two subarrays till a sorted
 * array is obtained.
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7, 13, 0};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    private static void sort(int[] arr, int lowIndex, int highIndex) {
        int middle = lowIndex + (highIndex - lowIndex) / 2;
        int pivot = arr[middle];
        int i = lowIndex;
        int j = highIndex;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (j > lowIndex) sort(arr, lowIndex, j);
        if (i < highIndex) sort(arr, i, highIndex);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
