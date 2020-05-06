package competitive;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Eagleview - Codility
 */
public class NoConsecutiveLetters {
    public String[] solution(int N, int K) {
        if (N == 0) {
            return new String[]{""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K - 1)) {
            for (char l : new char[]{'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
//        int prefSize = Math.min(result.size(), K); //Original
        int prefSize = (K <= 0) ? result.size() : Math.min(result.size(), K); //Improved
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }

    public static void main(String[] args) {
        NoConsecutiveLetters ncl = new NoConsecutiveLetters();
        System.out.println(Arrays.toString(ncl.solution(6, 4))); //New case
        System.out.println(Arrays.toString(ncl.solution(3,20)));
        System.out.println(Arrays.toString(ncl.solution(5,6)));
    }
}
