package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 4 - ATM
 */
public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0, y = 0;
        int N = Integer.parseInt(br.readLine()); // 줄 서있는 사람의 수
        int[] data = new int[N+1]; // 돈 인출하는데 걸리는 시간 저장
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬하면 최소임
        Arrays.sort(data);

        for (int i: data){
            x += i; // 현재까지 기다린 시간
            y += x; // 모든 사람이 돈을 인출하는 데 걸린 시간 누적합
        }
        System.out.println(y);
    }
}
