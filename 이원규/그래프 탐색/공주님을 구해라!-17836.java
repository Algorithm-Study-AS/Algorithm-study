import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, T;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = bfs();
        if (result == -1) System.out.println("Fail");
        else System.out.println(result);
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int ct = cur.cnt;
            boolean isGram = cur.isGram;
            if (ct > T) break;
            if (cx == N - 1 && cy == M - 1) return ct;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isInRange(nx, ny)) {
                    if (!isGram) { // 그람없음
                        if (!visited[nx][ny][0] && arr[nx][ny] == 0) {
                            q.add(new Node(nx, ny, ct + 1, false));
                            visited[nx][ny][0] = true;
                        } else if (!visited[nx][ny][0] && arr[nx][ny] == 2) {
                            q.add(new Node(nx, ny, ct + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    } else {
                        if (!visited[nx][ny][1]) {
                            q.add(new Node(nx, ny, ct + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }

        }
        return -1;
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}

class Node {
    int x;
    int y;
    int cnt;
    boolean isGram;

    public Node(int x, int y, int cnt, boolean isGram) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.isGram = isGram;
    }
}

/**
 * (N, M) 크기의 성 입구 (1,1)으로 들어옴
 * T시간 내에 공주님이 있는 곳에 도달
 * 출발지 -> 그람 -> 도착
 * 출발 -> 도착
 */