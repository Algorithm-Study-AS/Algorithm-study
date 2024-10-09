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
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (dp[i] == 1) {
                for (int j = i + 1; j < n; j++) {
                    if (((j - i) * (1 + Math.abs(arr[i] - arr[j]))) <= k) {
                        dp[j] = 1;
                    }
                }
            }
        }
        if (dp[n - 1] == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}


/**
 * 이해가 잘 안가서 검색..
 */