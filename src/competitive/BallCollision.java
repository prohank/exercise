package competitive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hackerrank - Paytm
 * Ball Collision
 * There are n balls placed on a 1-dimensional axis with each of them moving with the same non-zero speed.
 * direction[i] represents the direction in which the ith ball is moving,
 * with -1 meaning that it is moving to the left and 1 meaning it is moving to the right.
 * The strength of the ith ball is described by strength[i].
 * If 2 balls collide, the one with the higher strength destroys the smaller one.
 * If both have the same strength, both are destroyed.
 * Return a list of the indices of the balls that remain after all the collisions have occurred, in ascending order.
 * Note that the arrays direction and strength are O-indexed.
 * Example
 * direction = [1, -1] strength = [2, 1]
 * The number of balls n = 2.
 * The balls are listed in order of occurrence from left to right, so ball O is somewhere to the left of ball 1.
 * Ball O is moving to the right and ball 1 is moving to the left.
 * The balls will collide at some point and the ball with the higher strength, ball O, remains.
 * Return [O] as the answer.
 * Function Description
 * Complete the function findRemainingBalls in the editor below.
 * findRemaining Balls has the following parameter(s):
 * int direction[n]: the directions of the particles in order of their starting relative positions
 * int strength[n]: the strengths of the particles
 * Returns
 * int[]: an integer array that contains the indices of the remaining balls in ascending order
 * Constraints
 * •1 <= n <= 10^5
 * • direction[i] is either 1 or -1
 * • 1 <= strength[i] <= 10^9
 * Sample Case 0
 * Sample Input For Custom Testing
 * the number of balls n = 3
 * direction = [1, -1, 1]
 * strength = [5, 3, 1]
 * Sample Output
 * Explanation
 * The first and the third balls are moving right and the second ball is moving left.
 * The first and the second balls will collide at some point and the ball with higher strength, ball 0, remains.
 * The third ball does not collide with any ball.
 *
 */
public class BallCollision {
    public static void main(String[] args) {
        List<Integer> direction = Arrays.asList(1, -1, 1, 1);
        List<Integer> strength = Arrays.asList(16, 10, 4, 1);
        System.out.println("strength:" + strength);
        System.out.println("direction:" + direction);
        System.out.println(BallCollision.findRemainingBalls(direction, strength));
    }

    public static List<Integer> findRemainingBalls(List<Integer> direction, List<Integer> strength) {
        List<Integer> ballsList = new ArrayList<>();
        int noOfBalls = direction.size();
        if (noOfBalls == 1) {
            ballsList.add(0);
            return ballsList;
        }
//        while (strength.size() > 1 && direction.contains(-1) && direction.contains(1)) {
        for (int i = 0, j = i + 1; i < noOfBalls && j < noOfBalls; ) {
            if (strength.get(i) == 0 || strength.get(j) == 0) {
                i++;
                j++;
                continue;
            }

            if (direction.get(i) != direction.get(j)) {
                int stengthi = strength.get(i);
                int strengthj = strength.get(j);
                int sum = (direction.get(i) * stengthi) + (direction.get(j) * strengthj);
                int absSum = Math.abs(sum);
                if (stengthi > strengthj) {
                    strength.remove(i);
                    strength.add(i, absSum);
                    strength.remove(j);
                    strength.add(j, 0);
                    direction.remove(i);
                    direction.add(i, sum / absSum);
                    direction.remove(j);
                    direction.add(j, 0);
                } else if (stengthi < strengthj) {
                    strength.remove(j);
                    strength.add(j, absSum);
                    strength.remove(i);
                    strength.add(i, 0);
                    direction.remove(j);
                    direction.add(j, sum / absSum);
                    direction.remove(i);
                    direction.add(i, 0);
                } else {
                    strength.remove(j);
                    strength.add(j, 0);
                    strength.remove(i);
                    strength.add(i, 0);
                    direction.remove(j);
                    direction.add(j, 0);
                    direction.remove(i);
                    direction.add(i, 0);
                }
            }
            i = j;
            j++;
            System.out.println("strength:" + strength);
            System.out.println("direction:" + direction);
        }
        for (int k = 0; k < strength.size(); k++) {
            if (strength.get(k) != 0) {
                ballsList.add(k);
            }
        }
//        }
        return ballsList;
    }
}
