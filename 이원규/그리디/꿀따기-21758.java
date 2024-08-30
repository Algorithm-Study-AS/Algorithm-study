import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int case1 = case1();
        int case2 = case2();
        int case3 = case3();
        int max = Math.max(case1, Math.max(case2, case3));
        System.out.println(max);
    }

    private static int case1() { // 벌 벌 벌통
        int[] sum = new int[n];
        for (int i = 1; i < n; i++) { // 양끝에 벌과 벌통을 고정시키고 나머지 경우의 수를 구하는 것.
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int end = sum[n - 1];
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, end - arr[i] + sum[i]);
        }

        return max;
    }

    private static int case2() { // 벌통 벌 벌
        int[] sum = new int[n];
        for (int i = n - 2; i >= 0; i--) { // 위와 원리는 동일함
            sum[i] = sum[i + 1] + arr[i + 1];
        }
        int end = sum[0];
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, end - arr[i] + sum[i]);
        }

        return max;
    }

    private static int case3() { // 벌 벌통 벌
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        for (int i = 1; i < n; i++) { // 양 끝에 벌을 두고 벌통을 이동시켜서 경우의 수 구함
            leftSum[i] = leftSum[i - 1] + arr[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + arr[i];
        }
        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, leftSum[i] + rightSum[i]);
        }

        return max;
    }

}

/**
 * 3 ≤ N ≤ 100,000
 * 각 장소의 꿀의 양 1 이상 10000이하 정수
 * 왼쪽부터 각 장소에서 꿀을 딸 수 있는 양이 주어진다.
 * 장소들 중 서로 다른 두 곳을 골라서 벌을 배치한다.
 * 또 다른 장소를 골라서 벌통을 배치한다.
 * 벌이 벌통을 향해 날아가면서 표신된 양만큼 꿀을 딴다.
 * 시작점에서는 꿑따기 불가
 * <p>
 * 처음에 3중 for문 으로 풀다가 n^3으로 하면 터질거라고 생각함.
 * 총 3가지 경우의 수
 * 1. 벌 벌 벌통 -> 벌통이 오른쪽 고정
 * 2. 벌 벌통 벌 -> 벌통이 왼쪽 고정
 * 3. 벌통 벌 벌
 * <p>
 * 누적합
 */