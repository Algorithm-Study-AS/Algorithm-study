package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 실버 1 - 점프왕 쩰리 (Large)
 */
public class 점프왕쩰리 {

    static int n;
    static int[][] board;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][n];
        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cnt = board[curr[0]][curr[1]];
            if (cnt == -1) {
                System.out.println("HaruHaru");
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nx = curr[0] + dx[i] * cnt;
                int ny = curr[1] + dy[i] * cnt;
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        // 탐색이 모두 끝났지만 도달하지 못한 경우
        System.out.println("Hing");
    }
}
