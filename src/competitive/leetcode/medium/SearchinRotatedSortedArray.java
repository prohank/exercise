package competitive.leetcode.medium;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Date: 02-06-2020
 * Below solution is taken from Discussions
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (nums[mid] <= nums[end]) {
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray sirsr = new SearchinRotatedSortedArray();
        System.out.println(sirsr.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(sirsr.search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 3));
        System.out.println(sirsr.search(new int[]{4, 5, 6, 0, 1, 2, 3}, 3));
        System.out.println(sirsr.search(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 3));
        System.out.println(sirsr.search(new int[]{3, 4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(sirsr.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
    }
}
