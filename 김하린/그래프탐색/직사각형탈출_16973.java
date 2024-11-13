package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출_16973 {
    static int n, m;
    static int h, w, sr, sc, fr, fc;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken())-1;
        sc = Integer.parseInt(st.nextToken())-1;
        fr = Integer.parseInt(st.nextToken())-1;
        fc = Integer.parseInt(st.nextToken())-1;


        int ans = search();
        System.out.println(ans);
    }

    private static int search(){
        // 상 하 좌 우 (직사각형 이동 범위)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc, 0}); // 현재 위치, 이동 횟수
        visited[sr][sc] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int move = curr[2];

            if (r == fr && c == fc) return move; // 목적지
            for (int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (check(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, move+1});
                }
            }
        }
        return -1;
    }

    private static boolean check(int r, int c){
        // 범위 체크
        if (r<0 || c<0 || r+h>n || c+w>m) return false;

        // 직사각형이 벽에 겹치는지 확인 (한 번에 확인하기 위해 누적 합 이용) => 시간초과 해결....
        for (int i = r; i < r + h; i++) {
            if (map[i][c + w - 1] == 1 || map[i][c] == 1) {
                return false;
            }
        }

        for (int j = c; j < c + w; j++) {
            if (map[r + h - 1][j] == 1 || map[r][j] == 1) {
                return false;
            }
        }

        return true;
    }
    /**
     * 시간초과 코드
     *     private static boolean check(int r, int c){
     *         // 범위 체크
     *         if (r<0 || c<0 || r+h>n || c+w>m) return false;
     *         for (int i=r; i<r+h; i++){
     *             for (int j=c; j<c+w; j++){
     *                 if (map[i][j] == 1) return false;
     *             }
     *         }
     *         return true;
     *     }
     */
}
