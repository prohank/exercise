package competitive;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'droppedRequests' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY requestTime as parameter.
     */

    public static int droppedRequests(List<Integer> requestTime) {
        // Write your code here
        if (requestTime.size() < 2) return 0;
        int droppedCount = 0;
        for (int i = 0; i < requestTime.size(); i++) {

            if (i > 2 && requestTime.get(i) == requestTime.get(i - 3)) {
                droppedCount++;
            } else if (i > 19 && (requestTime.get(i) - requestTime.get(i - 20)) < 10) {
                droppedCount++;
            } else if (i > 59 && (requestTime.get(i) - requestTime.get(i - 60)) < 60) {
                droppedCount++;
            }
        }
        return droppedCount;
    }

}

public class ThrottlingGateway {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> requestTime = IntStream.range(0, requestTimeCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());

        Integer[] request = new Integer[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
        List<Integer> requestTime = Arrays.asList(request);

        int result = Result.droppedRequests(requestTime);

        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
