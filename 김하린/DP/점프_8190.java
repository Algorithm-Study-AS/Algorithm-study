package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 실버 1 - 점프
 * board[] : 게임판 정수 배열
 * dp[] : 칸에 도착하게 되는 경로의 개수
 * 1. board[0][0]일 때
 * - board[0][0]=2에서 다음 이동 칸 : board[0+2][0], board[0][0+2]
 * - dp[0+2][0] += dp[0][0], dp[0][0+2] += dp[0][0]
 * => dp[0][0] 을 1로 초기화해주면, dp[n-1][n-1]에 누적 경로 개수가 담긴다.
 * 2. board[i][j]
 * - dp[i+list[i][j]][j] += dp[i][j], dp[i][j+list[i][j]] += dp[i][j]
 */
public class 점프_8190 {
    static int n;
    static int[][] board;
    static long[][] dp;
    static class Solution {
        public long solution(int n, int[][] board) {
            dp[0][0] = 1;
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    // 종착점 도달 조건
                    if (i == n-1 && j == n-1) break;
                    // 아래
                    if (i + board[i][j] < n) dp[i + board[i][j]][j] += dp[i][j];
                    // 오른쪽
                    if (j + board[i][j] < n) dp[i][j + board[i][j]] += dp[i][j];
                }
            }
            return dp[n-1][n-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new long[n][n];
        // 점수판 입력받기
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solution s = new Solution();
        System.out.println(s.solution(n, board));
    }
}
