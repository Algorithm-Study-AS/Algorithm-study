import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(cir());
    }

    private static int cir() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j); // 이동할 인구수 반환
                        if (list.size() > 1) {
                            movePopulation(sum); //인구 이동
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) return result;
            result++; //국경이동시 일 추가
        }
    }

    private static void movePopulation(int sum) {
        int avg = sum / list.size();
        for (Node node : list) {
            arr[node.x][node.y] = avg;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();
        queue.add(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        int sum = arr[x][y];
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isInRange(nx, ny) && !visited[nx][ny]) {
                    int diff = Math.abs(arr[cur.x][cur.y] - arr[nx][ny]);
                    if (L <= diff && diff <= R) {
                        queue.add(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += arr[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return sum;
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
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
 * N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
 * 차이가 L, R 사이면 연합이 된다.
 * 1. 노드를 방문한다
 * 2. 방문하고 bfs
 * 3. 노드 체크 끝나면 인구이동
 * 4. 반복
 */