package competitive;

import java.util.Arrays;

/**
 * Given a sorted array return an array with square of its elements in sorted order
 */
public class SortedSquaredArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSortedSquaredArray(new int[]{-100, -4, -3, 1, 2, 5}))); //{1,4,9,16,25,10000}
        System.out.println(Arrays.toString(getSortedSquaredArray(new int[]{-100, -4, -3, 1, 2, 5, 6}))); //{1,4,9,16,25,36,10000}
    }

    static int[] getSortedSquaredArray(int[] arr) {
        int[] sortedSquaredArray = new int[arr.length];
        int[] squaredArray = new int[arr.length];
        int mid = 0;
        for (int i = 0; i < arr.length; i++) {
            squaredArray[i] = arr[i] * arr[i];
            if (arr[i] < 0) {
                mid++;
            }
        }
        int j = mid + 1;
        int k = 0;
        while (mid >= 0 && j < squaredArray.length) {
            if (squaredArray[mid] < squaredArray[j]) {
                sortedSquaredArray[k++] = squaredArray[mid--];
            } else if (squaredArray[j] < squaredArray[mid]) {
                sortedSquaredArray[k++] = squaredArray[j++];
            }
        }
        while (mid >= 0) {
            sortedSquaredArray[k++] = squaredArray[mid--];
        }
        while (j < squaredArray.length) {
            sortedSquaredArray[k++] = squaredArray[j++];
        }
        return sortedSquaredArray;
    }
}
