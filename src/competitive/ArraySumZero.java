package competitive;

/**
 * Eagleview - Codility
 * Limited testing
 */
public class ArraySumZero {
    public static void main(String[] args) {
        ArraySumZero asz = new ArraySumZero();
        int[] a = {2, -2, 3, 0, 4, -7, 3, 2, -2, -3};
        System.out.println(asz.solution(a));
    }

    int solution(int[] A) {
        int totalCount = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            if (A[i] == 0) totalCount++;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum == 0) {
                    totalCount++;
                    break;
                }
            }
        }
        if (totalCount > 100000) return -1;
        return totalCount;
    }
}
