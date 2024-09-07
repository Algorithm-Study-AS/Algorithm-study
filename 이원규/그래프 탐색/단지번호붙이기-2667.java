import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    cnt++;
                    pq.add(bfs(i, j));
                }
            }
        }
        System.out.println(cnt);
        pq.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    private static int bfs(int x, int y) {
        int ans = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        arr[x][y] = cnt;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isInRange(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    arr[nx][ny] = cnt;
                    ans++;
                }
            }
        }

        return ans;
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }

}

/**
 * 5≤N≤25
 * 1 -> 집
 * 0 -> 집x
 * bfs 돌면서 번호 넣기
 */