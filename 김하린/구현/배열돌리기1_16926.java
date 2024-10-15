package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 5 - 배열 돌리기 1
 * 겹(line)마다 [0][0] 값 저장후 끼워주기
 */
public class 배열돌리기1_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int line = Math.min(n, m)/2; // 회전 겹의 수

        int[][] arr = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<r; i++){
            for (int j=0; j<line; j++){
                int top = j;
                int left = j;
                int bottom = n-j-1;
                int right = m-j-1;
                // 첫 값 저장하기
                int save = arr[top][left];

                // 오른쪽 → 왼쪽으로 이동 (윗줄)
                for (int k = left+1; k<=right; k++) {
                    arr[top][k-1] = arr[top][k];
                }

                // 아래쪽 → 위쪽으로 이동 (오른쪽 줄)
                for (int k=top+1; k<=bottom; k++) {
                    arr[k-1][right] = arr[k][right];
                }

                // 왼쪽 → 오른쪽으로 이동 (아랫줄)
                for (int k=right-1; k>=left; k--) {
                    arr[bottom][k+1] = arr[bottom][k];
                }

                // 위쪽 → 아래쪽으로 이동 (왼쪽 줄)
                for (int k=bottom-1; k>=top; k--) {
                    arr[k+1][left] = arr[k][left];
                }

                // 마무리 시작값 끼우기
                arr[top+1][left] = save;
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
