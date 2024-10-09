import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int dir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void rotateArray() {
        int depth = Math.min(n, m) / 2;
        int x = 1, y = 1;

        while (r-- > 0) {
            for (int d = 0; d < depth; d++) {
                int cx = x + d;
                int cy = y + d;
                int tmp = arr[cx][cy];

                if (dir == 0) {
                    for (int i = 0; i < m - 2 * d - 1; i++) {
                        arr[cx][cy] = arr[cx + dx[dir]][cy + dy[dir]];
                        cx = cx + dx[dir];
                        cy = cy + dy[dir];
                    }
                    dir++;
                }
                if (dir == 1) {
                    for (int i = 0; i < n - 2 * d - 1; i++) {
                        arr[cx][cy] = arr[cx + dx[dir]][cy + dy[dir]];
                        cx = cx + dx[dir];
                        cy = cy + dy[dir];
                    }
                    dir++;
                }
                if (dir == 2) {
                    for (int i = 0; i < m - 2 * d - 1; i++) {
                        arr[cx][cy] = arr[cx + dx[dir]][cy + dy[dir]];
                        cx = cx + dx[dir];
                        cy = cy + dy[dir];
                    }
                    dir++;
                }
                if (dir == 3) {
                    for (int i = 0; i < n - 2 * d - 1; i++) {
                        arr[cx][cy] = arr[cx + dx[dir]][cy + dy[dir]];
                        cx = cx + dx[dir];
                        cy = cy + dy[dir];
                    }
                    arr[cx - dx[dir]][cy - dy[dir]] = tmp;
                    dir = 0;
                }

            }

        }
    }
}


/**
 * 2 ≤ N, M ≤ 300
 * 1 ≤ R ≤ 1,000
 * min(N, M) mod 2 = 0
 * 1 ≤ Aij ≤ 108
 * 0: 왼쪽
 * 1: 위쪽
 * 2: 오른쪾
 * 3: 아래쪽
 */