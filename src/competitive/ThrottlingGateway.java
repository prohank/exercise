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


public class ThrottlingGateway {

    /**
     * Throttling Gateway
     * Non-critical requests for a transaction system are routed through a throttling gateway to ensure that the network is not choked by non-essential requests.
     * The gateway has the following limits:
     * • The number of transactions in any given second cannot
     * exceed 3.
     * • The number of transactions in any given 10 second period
     * cannot exceed 20. A ten-second period includes all requests arriving from any time max(1, T-9) to T(inclusive of both) for
     * any valid time T.
     * • The number of transactions in any given minute cannot
     * exceed 60. Similar to above, 1 minute is from max(1, T-59) to T
     *
     * Any request that exceeds any of the above limits will be dropped by the gateway. Given the times at which different requests arrive sorted ascending, find how many requests will be dropped.
     * Note: Even if a request is dropped it is still considered for future calculations. Although, if a request is to be dropped due to multiple violations, it is still counted only once.
     * Example
     * n = 27
     * requestTime = [1, 1, 1, 1, 2, 2, 2,3,3,3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11]
     * • Request 1 - Not Dropped.
     * • Request 1 - Not Dropped.
     * • Request 1 - Not Dropped.
     * • Request 1 - Dropped. At most 3 requests are allowed in one
     * second.
     * • No request will be dropped till 6 as all comes at an allowed rate of
     * 3 requests per second and the 10-second clause is also not violated.
     *
     * • Request 7 - Not Dropped. The total number of requests has
     * reached 20 now.
     * • Request 7 - Dropped. At most 20 requests are allowed in ten
     * seconds.
     * • Request 7 - Dropped. At most 20 requests are allowed in ten
     * seconds.
     * • Request 7 - Dropped. At most 20 requests are allowed in ten
     * seconds. Note that the 1-second limit is also violated here.
     * • Request 11 - Not Dropped. The 10-second window has now
     * become 2 to 11. Hence the total number of requests in this
     * window is 20 now.
     * • Request 11 - Dropped. At most 20 requests are allowed in ten
     * seconds.
     * • Request 11 - Dropped. At most 20 requests are allowed in ten
     * seconds.
     * • Request 11 - Dropped. At most 20 requests are allowed in ten
     * seconds. Also, at most 3 requests are allowed per second.
     * Hence, a total of 7 requests are dropped.
     *
     * Function Description
     * Complete the dropped Requests function in the editor below.
     * droppedRequests has the following parameter(s):
     * int requestTime[n]: an ordered array of integers that represent the times of various requests
     * Returns
     * int: the total number of dropped requests
     *
     * Constraints
     *  1 <=n<= 10^6 •
     * 1 <= requestTime[i] <= 10^9
     */
    private static class Result {

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
