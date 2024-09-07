import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] tmp;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, max = 0;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 벽을 3개 세우고, bfs돌려서 영역크기 최대값 구하기
        makeWall(0);

        System.out.println(max);
    }

    private static void makeWall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] += 1;
                    makeWall(cnt + 1);
                    arr[i][j] -= 1;
                }
            }
        }
    }

    private static void resetTmp() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        tmp = new int[N][M];
        resetTmp();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isInRange(nx, ny) && tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    q.add(new Node(nx, ny));
                }
            }
        }
        countSafeArea();
    }

    private static void countSafeArea() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

}

/**
 * 3 ≤ N, M ≤ 8
 * 세로 크기 N과 가로 크기 M
 * 0은 빈 칸, 1은 벽, 2는 바이러스
 * 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수
 * 빈 칸의 개수는 3개 이상
 * cnt가 3이 되는 순간 bfs 실행 후 최대값 구하기
 */