package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 1 - 징검다리 건너기 (small)
 * 현재 돌 도달 체크해주면서 다음 도달 체크
 */
public class 징검다리건너기_22869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] bridge = new int[n];
        boolean[] dp = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = true;

        for (int i=0; i<n; i++) {
            if (dp[i]) {  // 현재 돌에 도달할 수 있으면
                for (int j = i+1; j<n; j++) {
                    if ((j-i) * (1 + Math.abs(bridge[i] - bridge[j])) <= k) {
                        dp[j] = true;  // j번째 돌로 도달 가능 표시
                    }
                }
            }
        }
        System.out.println(dp[n-1] ? "YES" : "NO");
    }
}
