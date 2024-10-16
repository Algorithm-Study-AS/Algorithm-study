package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 골드 5 - 빗물
 * 현재 높이보다 높은 블록이 왼쪽 or 오른쪽에 있어야 빗물 고임
 */
public class 빗물_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] blocks = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(blocks[j], left);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(blocks[j], right);
            }

            if(blocks[i] < left && blocks[i] < right) answer += Math.min(left, right) - blocks[i];
        }
        System.out.println(answer);
    }
}
