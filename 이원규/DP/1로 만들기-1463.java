import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 폴더의 총 개수
        int[] dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[N]);
    }

}
/**
 * 1보다 크거나 같고 10^6보다 작거나 같은 정수 N
 * X가 3의 배수 이면 /3
 * X가 2의 배수 이면 /2
 * -1
 * 1을 빼는것을 디폴트로 생각하고, 각각 2,3으로 조건 확인
 */