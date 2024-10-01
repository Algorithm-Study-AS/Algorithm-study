import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 위 오른쪽 아래 왼쪽
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int num = 1;

        int sx = N / 2;
        int sy = N / 2;
        arr[sx][sy] = num++;

        int idx = 0; // 현재 방향 인덱스 (0: 상, 1: 우, 2: 하, 3: 좌)
        int step = 1; // 이동 거리
        while (num <= N * N) {
            // step 만큼 반복하여 이동
            for (int i = 0; i < step; i++) {
                sx += dx[idx];
                sy += dy[idx];

                // 배열의 범위를 벗어나면 안 됨
                if (sx >= 0 && sy >= 0 && sx < N && sy < N) {
                    arr[sx][sy] = num++;
                }
            }
            idx = (idx + 1) % 4;
            // 두 번의 방향 전환마다 이동 거리를 1 증가시킴
            if (idx == 0 || idx == 2) {
                step++;
            }
        }

        int rx = 0, ry = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == T) {
                    rx = i + 1;
                    ry = j + 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(rx + " " + ry);
    }
}


/**
 * 홀수인 자연수 N(3 ≤ N ≤ 999)이 주어진다.
 * 위치를 찾고자 하는 N2 이하의 자연수
 */