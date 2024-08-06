package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 실버 5 - 다리 놓기
 * 조합으로 생각해보면 mCn 인 경우가 답이다. M개의 원소를 가지고 있는 집합에서 N개의 원소를 선택
 * mCn = m-1Cn-1 + m-1Cn
 */
public class 다리놓기_1010 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dp;

    static class Solution{
        public int solution(int N, int M){
            dp = new int[M+1][N+1];
            return combination(M, N);
        }

        private int combination(int M, int N){
            if(dp[M][N] >0){
                return dp[M][N];
            }
            if(N==M || N == 0){
                return dp[M][N] = 1;
            }
            dp[M][N] = combination(M-1, N-1) + combination(M-1, N);
            return dp[M][N];
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Solution s = new Solution();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            System.out.println(s.solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }
}
