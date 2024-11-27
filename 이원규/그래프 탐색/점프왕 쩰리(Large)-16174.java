import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int R, C, N;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean visited[][] = new boolean[N][N];
        visited[0][0] = true;
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            int cnt = arr[cx][cy];

            if (cnt == -1) {
                System.out.println("HaruHaru");
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx = cx + dx[i] * cnt;
                int ny = cy + dy[i] * cnt;
                if (!isInRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        System.out.println("Hing");
    }

    private static boolean isInRange(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }

}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 1. 외부로 이동시 패배
 * 2. 가장 왼쪽, 가장 위칸에서 시작
 * 3. 오른쪽, 아래쪽으로만 이동가능
 * 4. 가장 오른쪽, 아래로 가ㄴ면 종료
 */