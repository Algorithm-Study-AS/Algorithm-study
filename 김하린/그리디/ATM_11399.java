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
        int N = Integer.parseInt(br.readLine()); // 사람 수
        int[] data = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        for (int i: data){
            x += i;
            y += x;
        }
        System.out.println(y);
    }
}
