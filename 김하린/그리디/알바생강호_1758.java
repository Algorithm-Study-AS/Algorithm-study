package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 실버 4 - 알바생 강호
 * 원래돈 - (받은 등수 -1)
 * 민호 재필 주현
 * 3-(1-1) 2-(2-1) 1-(3-1)
 * N이 100,000 일 경우를 고려해서 answer 변수를 long으로 지정해줘야 맞음!!
 */
public class 알바생강호_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] tips = new Long[N];
        long answer = 0;

        for (int i=0; i<N; i++){
            tips[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(tips, Collections.reverseOrder()); // 내림차순일 때 최대임

        for (int j=0; j<N; j++){
            long tmp = tips[j] - j;
            if (tmp <=0) break;
            answer += tmp;
        }
        System.out.print(answer);
    }
}
