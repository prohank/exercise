package competitive;

import java.util.ArrayList;
import java.util.List;

/**
 * Hackerrank - Falabella
 * Sequence Construction
 * A challenge in a programming competition requires the construction of a sequence
 * using a specified number of integers within a range.
 * The sequence must be strictly increasing at first and then strictly decreasing.
 * The goal is to maximize the sequence array elements starting from the beginning.
 * For example, [4, 5, 4, 3, 2] beats [3, 4, 5, 4, 3] because its first element is larger,
 * and [4, 5, 6, 5, 4 beats [4, 5, 4, 3, 2] because its third element is larger.
 * Given the length of the sequence and the range of integers, return the winning sequence.
 * If it is not possible to construct such a sequence, return -1.
 * Example n = 5 lo = 3 hi = 10
 * In this case, [9, 10, 9, 8, 7] is the winning sequence.
 * It maintains the constraints of being first strictly increasing and then strictly decreasing,
 * and there is no way to have integers in the sequence that are greater than [9, 10, 9, 8, 7).
 * Function Description
 * Complete the function constructSequence in the editor below.
 * constructSequence has the following parameters:
 * int n: the size of the sequence to create
 * int lo: the lower end of the integer range
 * int hi: the upper end of the integer range
 * Returns
 * int[n] or int[1]: the winning sequence of n integers, or [-1] if this is impossible
 * Constraints
 * • 3 <= n <= 10^5
 * • 1 <= lo <= hi <= 10^5
 *
 * Sample Case 0
 * Sample Input For Custom Testing
 * n = 5 lo = 4 hi = 11
 * Sample Output
 * 10
 * 11
 * 10
 * Explanation
 * Since 11 is the upper bound, a sequence starting with 11 cannot be strictly increasing at the first.
 * The next best answer is the sequence starting with 10, which is [10, 11, 10, 9, 8].
 *
 * Sample Case 1
 * Sample Input For Custom Testing
 * n = 5 lo = 1 hi = 2
 * Sample Output
 * -1
 * Explanation
 * It is impossible to construct a valid sequence using only 1 and 2.
 * The only valid sequence with those two limits is [1, 2, 1].
 * Anything shorter or longer cannot be strictly increasing then strictly decreasing. Therefore, the answer is [-1].
 */
public class SequenceReconstruction {

    public static void main(String[] args) {
        System.out.println(SequenceReconstruction.constructSequence(5, 3, 10)); //[9,10,9,8,7]
    }

    public static List<Integer> constructSequence(int n, int lo, int hi) {
        // Write your code here
        List<Integer> sequence = new ArrayList<>();
        int range = (hi - lo) * 2 - 1;
        if (n > range) {
            sequence.add(-1);
        } else {
            int decreasingSequenceMaxCount = 0;
            int increasingSequenceMaxCount = 0;
            if (hi - lo > n - 1) {
                decreasingSequenceMaxCount = hi - lo - n + 1;
            } else {
                decreasingSequenceMaxCount = hi - lo - 1;
            }
            increasingSequenceMaxCount = n - decreasingSequenceMaxCount;
            int count = increasingSequenceMaxCount;
            int startFrom = hi - increasingSequenceMaxCount + 1;
            while (count > 0) {
                sequence.add(startFrom);
                startFrom++;
                count--;
            }
            count = decreasingSequenceMaxCount;
            startFrom = hi - 1;
            while (count > 0) {
                sequence.add(startFrom);
                startFrom--;
                count--;
            }
        }
        return sequence;
    }
}
