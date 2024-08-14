package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 1 - 포도주 시식
 * 맨 오른쪽이 현재 위치
 * 1. oox : dp[i-1]
 * 2. oxo : dp[i-2] + arr[i]
 * 3. xoo : dp[i-3] + arr[i-1] + arr[i]
 */
public class 포도주시식_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int [n];

        // 와인 입력받기
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        for (int i=1; i<n; i++){
            // n 범위 1부터여서 밖으로 빼면 에러남
            if (i==1){
                dp[1] = arr[0] + arr[1];
                continue;
            }
            if (i==2){
                dp[2] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
                continue;
            }
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
        }
        System.out.println(dp[n-1]);
    }
}
