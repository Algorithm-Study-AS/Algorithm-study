package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 실버 3 - 달팽이
 * 0,0 부터 숫자 거꾸로 생각해서 품
 */
public class 달팽이_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] snail = new int[n+1][n+1];
        // 방향: 하, 우, 상, 좌
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0; // 시작점 (좌측 상단 부터)
        int num = n * n; // n^2부터 시작
        int targetX = -1, targetY = -1; // 목표 숫자의 좌표

        int dir = 0; // 현재 이동 방향
        while (num > 0) {
            snail[x][y] = num;
            if (num == target) {
                targetX = x + 1;
                targetY = y + 1;
            }
            num--; // 숫자를 줄여가며 채움

            // 다음 좌표
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 경계를 벗어나거나 이미 숫자가 있으면 방향 바꾸기
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || snail[nx][ny] != 0) {
                dir = (dir + 1) % 4; // 방향 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }


        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(snail[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(targetX + " " + targetY);
    }
}
