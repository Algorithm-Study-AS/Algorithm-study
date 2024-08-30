package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 골드 5 - 토마토
 */
public class 토마토_7569 {
    static int M, N, H;
    static int[][][] map;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];

        Queue<int[]> queue = new LinkedList<>();

        // 초기 상태 입력 및 익은 토마토 큐에 추가
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    }
                }
            }
        }

        System.out.println(bfs(queue));
    }

    static int bfs(Queue<int[]> queue) {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean ripened = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int z = curr[0], x = curr[1], y = curr[2];

                for (int d = 0; d < 6; d++) {
                    int nz = z + dz[d];
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nz < 0 || nz >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = 1;
                        queue.add(new int[]{nz, nx, ny});
                        ripened = true;
                    }
                }
            }

            if (ripened) days++;
        }

        // 모든 토마토가 익었는지 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[h][n][m] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days;
    }
}
