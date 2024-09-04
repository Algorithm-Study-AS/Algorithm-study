import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] diff = new int[n - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n <= k) {
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}

/**
 * 센서의 개수 N(1 ≤ N ≤ 10,000),
 * 집중국의 개수 K(1 ≤ K ≤ 1000)가 주어진다
 * 수신 가능영역의 거리의 합의 최솟값
 * arr을 정렬.
 * diff에 차이를 담고 정렬
 * n=6 이고 k=2 일때
 * 1 3 6 6 7 9의 차이의 정렬
 * 0 1 2 2 3 에서 n-k인 4만큼의 센서를 한 집중국이 책임져야함.
 */