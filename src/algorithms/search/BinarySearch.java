package algorithms.search;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                return binarySearch(nums, start, mid - 1, target);
            } else if (target > nums[mid]) {
                return binarySearch(nums, mid + 1, end, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch sirsr = new BinarySearch();
        System.out.println(sirsr.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 4));
        System.out.println(sirsr.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 2));
        System.out.println(sirsr.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 5));
        System.out.println(sirsr.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 7));
        System.out.println(sirsr.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0));
        System.out.println(sirsr.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 3));
    }
}
