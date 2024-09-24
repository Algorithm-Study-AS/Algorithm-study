package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

/**
 * 실버 4 - 인구 이동
 * 1. graph에 값 넣기
 * 2. 인구 차이 조건으로 연합 인구수 업데이트
 * 3. 연합에 속한 모든 나라의 인구수 graph에 갱신
 */
public class 인구이동_16234 {
    static int[][] graph;
    static boolean[][] visited;
    static int n, l, r;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean isMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) { // 모든 나라에 대해 BFS 탐색
                            isMoved = true; // 인구 이동 발생한 경우
                        }
                    }
                }
            }

            if (!isMoved) break; // 인구이동 끝나면 종료
            days++;
        }

        System.out.println(days);
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>(); // 연합에 속하는 나라 리스트

        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = graph[x][y]; // 연합 인구수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(graph[cx][cy] - graph[nx][ny]);
                    if (diff >= l && diff <= r) { // 인구차이 조건
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        sum += graph[nx][ny];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int newPopulation = sum / union.size();
            for (int[] pos : union) { // 연합에 속한 모든 나라의 인구수 갱신
                graph[pos[0]][pos[1]] = newPopulation;
            }
            return true;
        }
        return false;
    }
}
