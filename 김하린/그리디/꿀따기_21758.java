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
        honey = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            long a = Long.parseLong(st.nextToken());
            honey[i] = a;
        }

        // 1. 벌 왼쪽, 꿀통 오른쪽 고정
        long fixBee = Arrays.stream(honey).sum() - honey[0];
        long moveBee = fixBee;
        for (int i=1; i<=honey.length-2; i++){
            long sum = fixBee - honey[i];
            moveBee = moveBee - honey[i];
            sum += moveBee;
            cnt = Math.max(sum, cnt);
        }

        // 2. 벌 오른쪽 고정, 꿀통 왼쪽 고정
        fixBee = fixBee + honey[0] - honey[honey.length-1];
        moveBee = fixBee;
        for (int i=honey.length-2; i>=0; i--){
            long sum = fixBee - honey[i];
            moveBee = moveBee - honey[i];
            sum += moveBee;
            cnt = Math.max(sum, cnt);
        }

        // 3. 벌 양쪽 고정, 꿀통 움직임
        fixBee = 0;
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
