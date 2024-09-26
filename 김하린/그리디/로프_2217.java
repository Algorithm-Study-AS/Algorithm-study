package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 실버 4 - 로프
 * 1. 로프 임의로 몇 개 고를 수 있음
 * 2. 로프 안꺠내기 vs 꺼내기 중 최댓값 업데이트
 * w = k * (로프 중 최소 무게)
 */
public class 로프_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        int answer = 0;
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i=0; i<n; i++){
            answer = Math.max(answer, arr[i] * (i+1)); // 로프 개수만큼 곱해주기
        }
        System.out.println(answer);
    }
}
