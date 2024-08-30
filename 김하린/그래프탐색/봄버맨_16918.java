package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * 실버 1 - 봄버맨
 * 크기 R*C
 * 폭탄이 있는 칸은 3초가 지난 후에 폭발
 * 폭탄이 있던 칸이 (i, j)인 경우에 (i+1, j), (i-1, j), (i, j+1), (i, j-1)도 함께 파괴
 * 0초 - 폭탄 설치
 * 1초 - 가만히
 * 2초 - 폭탄 놓음 (모든 칸)
 * 3초 - 폭탄 터짐 (0초에 설치된 폭탄)
 * 4초 - 폭탄 놓음 (모든 칸)
 * 5초 - 폭탄 터짐 (2초에 설치된 폭탄)
 */
public class 봄버맨_16918 {

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        int[][] bombtime = new int[R][C];

        // 초기 상태
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'O') bombtime[i][j] = 3; // 폭탄이 터질 시간
            }
        }

        int time = 0;
        int[] mi = {1, -1, 0, 0};
        int[] mj = {0, 0, 1, -1};
        while (time++ < N){
            if (time % 2 == 0) {
                // 모든 칸에 폭탄 설치
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombtime[i][j] = time + 3; // 폭탄이 터질 시간
                        }
                    }
                }
            } else {
                // 시간 다 된 폭탄
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombtime[i][j] == time) {
                            map[i][j] = '.';
                            for (int k=0; k<4; k++){
                                int ni = i+mi[k];
                                int nj = j+mj[k];
                                if (ni<0 || nj<0 || ni>=R || nj>=C) continue;
                                // 미리 터트린 폭탄의 주변 폭탄 연쇄시키기 위해 bombtime 확인
                                if (map[ni][nj] == 'O' && bombtime[ni][nj] != time){
                                    map[ni][nj] = '.';
                                    bombtime[ni][nj] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }
    }
}
