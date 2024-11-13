import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, H, W, Sr, Sc, Fr, Fc;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] isVisit;
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        isVisit = new boolean[N + 1][M + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    list.add(new Node(i, j, 0));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken());
        Sc = Integer.parseInt(st.nextToken());
        Fr = Integer.parseInt(st.nextToken());
        Fc = Integer.parseInt(st.nextToken());

        int cnt = bfs();

        System.out.println(cnt);
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
//        boolean[][] isVisit = new boolean[N + 1][M + 1];
        q.add(new Node(Sr, Sc, 0));
        isVisit[Sr][Sc] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            if (cx == Fr && cy == Fc) {
                return cur.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

//                if (!isInRange(nx, ny) && isVisit[nx][ny]) {
//                    continue;
//                }
                if (nx < 1 || ny < 1 || nx > N || ny > M || isVisit[nx][ny])
                    continue;
                if (!isCanMove(nx, ny))
                    continue;

                if (arr[nx][ny] == 0) {
                    isVisit[nx][ny] = true;
                    q.add(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }
        return -1;
    }

    private static boolean isCanMove(int nx, int ny) {
//        for (int i = nx; i < nx + H; i++) {
//            for (int j = ny; j < ny + W; j++) {
//                if (i < 1 || j < 1 || i > N || j > M || arr[i][j] == 1)
//                    return false;
//            }
//        }
        // 사각형이 범위를 벗어나면 false 반환
        if (nx + H - 1 > N || ny + W - 1 > M) return false;
        for (int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);
            int cx = cur.x;
            int cy = cur.y;
            if (nx <= cx && cx <= nx + H - 1 && ny <= cy && cy <= ny + W - 1)
                return false;
        }

        return true;
    }

//    private static boolean isInRange(int nx, int ny) {
//        return nx > 0 && ny > 0 && nx <= N && ny <= M;
//    }
}

class Node {
    int x, y, cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

/**
 * 0은 빈칸, 1은 벽
 * 마지막줄
 * 직사각형 크기 H W
 * 시작좌표 Sr Sc
 * 도착좌표 Fr Fc
 * 시간 초과나서 열심히 고쳐봄 6번트라이 실패 후 검색해봤더니
 * 벽을 저장하는 방식 발견.
 * 이후 3번 더 틀리고 겨우 통과됨
 */