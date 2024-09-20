import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] * (n - i));
        }
        System.out.println(max);
    }
}


/**
 * N(1 ≤ N ≤ 100,000)개의 로프
 * 각 로프가 버틸 수 있는 최대 중량 입력
 * k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때,
 * 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
 * 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램
 * 모든 로프 사용할 필요없음
 * arr[i]번째 중량에서 로프 개수 n-i를 곱한게 최대값임.
 * 10 20 30 40 인 경우
 * 10 * 4 = 40
 * 20 * 3 = 60
 * 30 * 2 = 60
 * 40 * 1 = 40
 */