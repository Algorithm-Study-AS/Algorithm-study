package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 3 - 1로 만들기
 */
public class 일로만들기_1463 {
    static class Solution{
        public int solution(int x){
            int[] dp = new int[x+1];
            for (int i=2; i<=x; i++){
                dp[i] = dp[i-1] + 1; // 1 빼기
                if (i%2 == 0){
                    dp[i] = Math.min(dp[i], dp[i/2] + 1); // 2 나누기
                }
                if (i%3 == 0){
                    dp[i] = Math.min(dp[i], dp[i/3] + 1); // 3 나누기
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
