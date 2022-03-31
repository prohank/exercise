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
 * [0,2]
 * Explanation
 * The first and the third balls are moving right and the second ball is moving left.
 * The first and the second balls will collide at some point and the ball with higher strength, ball 0, remains.
 * The third ball does not collide with any ball.
 */
public class BallCollision {
    public static void main(String[] args) {
        int[] direction1 = new int[]{1, -1, -1, 1};
        int[] strength1 = new int[]{16, 10, 4, 1};
        System.out.println("strength1:" + Arrays.toString(strength1) + " direction1:" + Arrays.toString(direction1));
        System.out.println(BallCollision.findRemainingBalls(direction1, strength1));
        int[] direction2 = new int[]{1, -1, -1, 1};
        int[] strength2 = new int[]{10, 16, 4, 10};
        System.out.println("strength2:" + Arrays.toString(strength2) + " direction2:" + Arrays.toString(direction2));
        System.out.println(BallCollision.findRemainingBalls(direction2, strength2));
    }

    public static List<Integer> findRemainingBalls(int[] direction, int[] strength) {
        List<Integer> ballsList = new ArrayList<>();
        int noOfBalls = direction.length;
        if (noOfBalls == 1) {
            ballsList.add(0);
            return ballsList;
        }
        for (int i = 0, j = i + 1; i < noOfBalls && j < noOfBalls; j++) {
            if (strength[i] == 0) {
                i++;
                continue;
            } else if(strength[j] == 0){
                continue;
            }

            if (direction[i] != direction[j]) {
                int stengthi = strength[i];
                int strengthj = strength[j];
                int sum = (direction[i] * stengthi) + (direction[j] * strengthj);
                int absSum = Math.abs(sum);
                if (stengthi > strengthj) {
                    strength[i] = absSum;
                    strength[j] = 0;
                    direction[i] = sum / absSum;
                    direction[j] = 0;
                } else if (stengthi < strengthj) {
                    strength[j] = absSum;
                    strength[i] = 0;
                    direction[j] = sum / absSum;
                    direction[i] = 0;
                    i++;
                } else {
                    strength[j] = 0;
                    strength[i] = 0;
                    direction[j] = 0;
                    direction[i] = 0;
                    i=j;
                }
            } else {
                i++;
            }
            System.out.println("strength:" + Arrays.toString(strength) + " direction:" + Arrays.toString(direction));
        }
        for (int k = 0; k < strength.length; k++) {
            if (strength[k] != 0) {
                ballsList.add(k);
            }
        }
        return ballsList;
    }
}
