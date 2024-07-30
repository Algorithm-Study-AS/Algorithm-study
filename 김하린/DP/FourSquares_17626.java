package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버 3 - Four Squares
 * dp[1] = 1, dp[2] = 2, dp[3] = 3,
 * dp[4] = 1, dp[5] = 2, dp[6] = 3, dp[7] = 4, dp[8] = 2,
 * dp[9] = 1
 * 규칙 : dp[i]를 갱신할 때, dp[i - j*j] + 1 중 최솟값만 선택하는 방식
 */
public class FourSquares_17626 {
    static class Solution {
        public int solution(int x) {
            int[] dp = new int[x+1];
            Arrays.fill(dp, Integer.MAX_VALUE); // dp 배열 초기화
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= x; i++) {
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
                }
            }
            return dp[x];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution s = new Solution();
        System.out.println(s.solution(Integer.parseInt(br.readLine())));
    }
}