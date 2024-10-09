package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 골드 5 - 퇴사 2
 */
public class 퇴사2_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n+1][2];
        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++){
            dp[i] = Math.max(dp[i], dp[i-1]); // i날 까지 받을 수 있는 금액
            int next = i + schedule[i][0]; // 상담 끝나는 날
            if (next <= n+1) dp[next-1] = Math.max(dp[next-1], dp[i-1]+schedule[i][1]);
        }

        System.out.println(dp[n]);
    }
}
