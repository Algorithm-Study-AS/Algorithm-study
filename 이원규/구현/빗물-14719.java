import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); //세로
        int W = Integer.parseInt(st.nextToken()); //가로
        int[] arr = new int[W];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            //왼쪽에서 제일 높은 벽
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            //오른쪽에서 제일 높은 벽
            for (int j = i + 1; j < W; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            if (arr[i] < leftMax && arr[i] < rightMax) {
                result += Math.min(leftMax, rightMax) - arr[i];
            }
        }
        System.out.println(result);
    }

}


/**
 * 현재 인덱스 기준으로 양 옆을 탐색해서 가장 높은 벽을 찾는다.
 * 둘 중에서 더 낮은 높이와 현재 인덱스 차이를 더한다.
 */