import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //10 20 10 30 20 50
        //dp는 1 2 1 3 2 4 가 된다.
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        Arrays.sort(dp);
        int max = dp[N - 1];
        System.out.println(max);

    }
}


/**
 * N (1 ≤ N ≤ 1,000)
 * i보다 작은 값들을 탐색하면서 해당 값이 i번째보다 작은 경우를 찾고 dp계산한다.
 * arr[i]가 arr[j]보다 크고, dp[i]가 dp[j] + 1보다 작다면 dp[i] 갱신
 * dp 배열을 정렬하여 최장 증가 부분 수열의 길이인 최대값을 찾음
 *
 */