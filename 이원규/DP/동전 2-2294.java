import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[k + 2];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i <= k + 1; i++) {
            dp[i] = 10000000;
        }

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        if (dp[k] == 10000000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }

}

/**
 * 1 5 12
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 * 0 1 2 3 4 1 2 3 4 5  2  3  4  5  6  3
 * 0 1 2 3 4 1 2 3 4 5  2  3  1  2  3  3
 */
