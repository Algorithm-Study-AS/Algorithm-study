import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 사람1
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i + T[i] <= n) {
                //(오늘 날짜 + 상담 완료 날짜) vs 그동안 최대 수입 + 오늘 수입
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            //상담중에도 최대 금액 최신화
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.println(dp[n]);
    }

}

/**
 * 상담을 완료하는데 걸리는 기간 T
 * 상담을 했을 때 받을 수 있는 금액 P
 */