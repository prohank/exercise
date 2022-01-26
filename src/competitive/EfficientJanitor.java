package competitive;

/**
 * Hackerrank
 * 23/01/2022 - Solution tested with limited cases
 * The janitor of a high school is extremely efficient.
 * By the end of each day, all of the school's waste is in plastic bags weighing between 1.01 pounds and 3.00 pounds.
 * All plastic bags are then taken to the trash bins outside.
 * One trip is described as selecting a number of bags which together do not weigh more than 3.00 pounds,
 * dumping them in the outside trash can and returning to the school.
 * Given the number of plastic bags n, and the weights of each bag, determine the minimum number of trips the janitor has to make.
 * Example
 * n = 5 weight = [1.01, 1.99, 2.5, 1.5, 1.01]
 * The janitor can carry all plastic bags out in 3 trips: [1.01 + 1.99, 2.5, 1.5 +1.01].
 * Function Description
 * Complete the function efficientjanitor in the editor below.
 * efficientjanitor has the following parameter(s):
 * float weight[n]: weights of the bags
 * Returns
 * int: the minimum number of trips required
 * Constraints
 * • 1 <= n <= 1000
 * • 1.01 <= weight[i] <= 3.0
 */
public class EfficientJanitor {
    public static void main(String[] args) {
        System.out.println(EfficientJanitor.efficientjanitor(new double[]{1.01, 1.99, 2.5, 1.5, 1.01}));
        System.out.println(EfficientJanitor.efficientjanitor(new double[]{3.00}));
        System.out.println(EfficientJanitor.efficientjanitor(new double[]{1.01}));
        System.out.println(EfficientJanitor.efficientjanitor(new double[]{2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5,
                2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5}));
    }

    private static int efficientjanitor(double[] weights) {
        int weightCount = weights.length;
        int trips = weightCount;
        for (int i = 0; i < weightCount; i++) {
            if (weights[i] == 0) {
                trips--;
                continue;
            }
            double weight = weights[i];
            for (int j = i + 1; j < weightCount; j++) {
                if (weight + weights[j] <= 3.00) {
                    weight += weights[j];
                    weights[j] = 0;
                } else if (weight == 3.00) break;
            }
        }
        return trips;
    }
}
