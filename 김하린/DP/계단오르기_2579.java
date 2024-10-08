package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 실버 3 - 계단 오르기
 * - dp[i-2] vs dp[i-3]+arr[i-1]
 */
public class 계단오르기_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n+1];
        for (int i=1; i<=n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        dp[1] = stairs[1];
        if(n>=2) dp[2] = stairs[1]+ stairs[2];
        for (int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+stairs[i-1]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}
