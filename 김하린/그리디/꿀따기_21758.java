package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 골드 5 - 꿀 따기
 * 1. 벌 왼쪽 고정, 꿀통 오른쪽 고정
 * 2. 벌 오른쪽 고정, 꿀통 왼쪽 고정
 * 3. 벌 양쪽 고정, 꿀통 움직임
 * 어려워서 구글링으로 풀음 ...
 */
public class 꿀따기_21758 {
    static long[] honey;
    static int n;
    static long cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        honey = new long[n]; // 각 장소에 있는 꿀의 양
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            long a = Long.parseLong(st.nextToken());
            honey[i] = a;
        }

        // 1. 벌 왼쪽, 꿀통 오른쪽 고정
        // 오른쪽 끝에 있는 벌통과 왼쪽 끝에 있는 벌이 고정된 상태에서 벌이 얻을 수 있는 꿀의 총합
        long fixBee = Arrays.stream(honey).sum() - honey[0];
        // 두 번째 벌이 위치를 이동하면서 얻을 수 있는 꿀의 양을
        long moveBee = fixBee;
        for (int i=1; i<=honey.length-2; i++){
            long sum = fixBee - honey[i];
            moveBee = moveBee - honey[i];
            sum += moveBee;
            cnt = Math.max(sum, cnt);
        }

        // 2. 벌 오른쪽 고정, 꿀통 왼쪽 고정
        // 왼쪽 끝에 있는 벌통과 오른쪽 끝에 있는 벌이 고정된 상태에서 벌이 얻을 수 있는 꿀의 총합
        fixBee = fixBee + honey[0] - honey[honey.length-1];
        // 두 번째 벌이 위치를 이동하면서 얻을 수 있는 꿀의 양
        moveBee = fixBee;
        for (int i=honey.length-2; i>=0; i--){
            long sum = fixBee - honey[i];
            moveBee = moveBee - honey[i];
            sum += moveBee;
            cnt = Math.max(sum, cnt);
        }

        // 3. 벌 양쪽 고정, 꿀통 움직임
        // 첫 번째 벌이 출발하여 지나간 꿀의 양을 추적
        fixBee = 0;
        // 중간 벌통 위치에서 벌들이 얻을 수 있는 꿀의 양
        moveBee = Arrays.stream(honey).sum() - honey[honey.length - 1];
        for (int i=1; i<=honey.length-2; i++){
            long sum = 0;
            fixBee += honey[i];
            moveBee = moveBee - honey[i-1];
            cnt = Math.max(fixBee + moveBee, cnt);
        }
        System.out.println(cnt);
    }
}
