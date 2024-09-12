package 그리디;
import java.util.*;
import java.io.*;

/**
 * 골드 5 - 행복 유치원
 * n명 일렬 줄세우고 k개의 조로 나누기
 * 티셔츠 비용 = 키 차이
 */
public class 행복유치원_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] students = new int[n]; // 학생들 키 배열
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            students[i] = Integer.parseInt(st.nextToken());
        }

        int[] diffs = new int[n-1]; // 키차이 배열
        int answer = 0;

        for (int i=0; i<n-1; i++){
            diffs[i] = students[i+1] - students[i];
        }

        Arrays.sort(diffs);

        for (int i = 0; i < n - k; i++) {
            answer += diffs[i]; // 가장 큰 차이 (K-1)개를 제외 남은 차이들만 합산
        }

        System.out.println(answer); // 최소 비용 출력
    }
}
