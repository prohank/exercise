package competitive.leetcode.april;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight lsw = new LastStoneWeight();
        System.out.println(lsw.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lsw.lastStoneWeight(new int[]{2}));
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        Arrays.sort(stones);
        for (int i = stones.length - 1; stones[i - 1] > 0; ) {
            int diff = Math.abs(Math.subtractExact(stones[i], stones[i - 1]));
            stones[i] = 0;
            stones[i - 1] = diff;
            Arrays.sort(stones);
        }

        return stones[stones.length - 1];
    }
}

/* Other solutions
    public int lastStoneWeight(int[] stones) {
        List<Integer> nums = Arrays.stream(stones).boxed().collect(Collectors.toList());
        for (int i = nums.size() - 1; i > 0; i--) {
            Collections.sort(nums);
            int diff = Math.abs(Math.subtractExact(nums.get(i), nums.get(i - 1)));
            nums.remove(i);
            nums.set(i - 1, diff);
        }

        return nums.get(0);
    }
*/