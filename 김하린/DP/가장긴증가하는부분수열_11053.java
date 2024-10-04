package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 실버 2 - 가장 긴 증가하는 부분 수열
 */
public class 가장긴증가하는부분수열_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] dp = new int[n];  // dp[i]: a[i]를 끝으로 하는 가장 긴 증가하는 부분 수열의 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;  // 최소 길이는 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  // 초기화: 자기 자신만을 포함하는 부분 수열의 길이는 1
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // 증가하는 수열일 때
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
