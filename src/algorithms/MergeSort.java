package algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7, 13, 0};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        sort(arr, 0, (arr.length - 1));
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {

        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
//        int n1 = m-l+1;
//        int n2 = r-m;
//        int[] L = new int[n1];
//        int[] R = new int[n2];

//        for (int i=0; i<n1; ++i)
//            L[i] = arr[l + i];
//        for (int j=0; j<n2; ++j)
//            R[j] = arr[m + 1+ j];
        // OR //
        int[] L = Arrays.copyOfRange(arr, l, m + 1);
        int[] R = Arrays.copyOfRange(arr, m + 1, r + 1);

        int n1 = L.length;
        int n2 = R.length;
        //
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
        System.out.println("Left: " + Arrays.toString(L));
        System.out.println("Right: " + Arrays.toString(R));
        System.out.println("Sorted: " + Arrays.toString(arr));

    }
}
