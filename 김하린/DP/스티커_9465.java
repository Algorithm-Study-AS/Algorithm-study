package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 1 - 스티커
 * 1, 2 열 : 스티커는 대각선으로 뗄 수 있음.
 * 3 열 : (인덱스 - 2)의 값이 더 큰 경우까지 고려해줘야함
 * 점화식 :
 * - DP[0][N] = Max(DP[1][N-1], DP[1][N-2]) + sticker[0][N]
 * - DP[1][N] = Max(DP[0][N-1], DP[0][N-2]) + sticker[1][N]
 */
public class 스티커_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        int T;
        int[][] dp;

        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            T = Integer.parseInt(br.readLine());
            dp = new int[2][T];

            for(int j=0; j<2; j++){
                st = new StringTokenizer(br.readLine(), " ");
                // 스티커 값 입력
                for(int k=0; k<T; k++){
                    dp[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j=1; j<T; j++){
                // 첫 번째 행의 j번째 스티커 선택
                dp[0][j] += j == 1 ? dp[1][j - 1] : Math.max(dp[1][j - 2], dp[1][j - 1]);
                // 두 번째 행의 j번째 스티커 선택
                dp[1][j] += j == 1 ? dp[0][j - 1] : Math.max(dp[0][j - 2], dp[0][j - 1]);
            }
            // 마지막 열에서 최대 값 출력
            System.out.println(Math.max(dp[0][T - 1], dp[1][T - 1]));
        }
    }
}
