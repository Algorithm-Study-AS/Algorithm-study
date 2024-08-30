package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 1 - 회의실 배정
 * N : 회의의 수
 * 회의 시작시간 ~ 끝나는 시간
 * 1. 종료시간 기준 정렬 (같으면 시작시간 비교)
 * 2. 이전 종료시간에 대해 겹치는 것들은 제외
 */
    public class 회의실배정_1931 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        int count = 0, end = 0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0]; // 종료시간 같으면 시작시간 빠른 순
            return o1[1] - o2[1]; // 종료시간 기준 정렬
        });

        for (int i=0; i<N; i++){
            if (end <= time[i][0]){
                end = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
