import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] distance = new long[n];
        long[] cost = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        long min = cost[0];
        for (int i = 0; i < n - 1; i++) {
            if (min > cost[i]) {
                min = cost[i];
            }
            sum += min * distance[i];
        }
        System.out.println(sum);
    }
}

/**
 * 도시의 개수 2 ≤ N ≤ 100,000
 * 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수
 * 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수
 * 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수
 * 리터당 가격은 1 이상 1,000,000,000 이하의 자연수
 * 그냥 왼쪽부터 최소 길이만큼 이동하면서 기름값 비교한다.
 */