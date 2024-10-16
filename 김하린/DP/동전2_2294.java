package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 골드 5 - 동전 2
 * 가치 합 k, 동전 개수 최소
 * dp에 동전 개수 넣기
 * i = 1 -> 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
 * i = 5 -> 0, 1, 2, 3, 4, 1=dp[0]+1, 2=dp[1]+1, 3, 4, 5, 2=dp[5]+1, 3, 4, 5, 6, 7
 * i = 12-> 0, 1, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 1, 2, 3, 4
 */
public class 동전2_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] value = new int[n+1];
        int[] dp = new int[k+1];
        for (int i=1; i<=n; i++){
            value[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(value);
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i=1; i<=n; i++){
            for (int j=value[i]; j<=k; j++){
                //System.out.println(Arrays.toString(dp));
                //System.out.println("j : " + j + " value[i] : " + value[i]);
                //System.out.println("j - value[i] " + (j - value[i]) + " dp[j - value[i]] " + dp[j - value[i]]);
                dp[j] = Math.min(dp[j], dp[j - value[i]] + 1);
            }
        }

        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}
