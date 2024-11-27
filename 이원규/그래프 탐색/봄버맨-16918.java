import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[][] boom;
    static int R, C, N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        boom = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'O') {
                    boom[i][j] = 3;
                }
            }
        }

        bfs();

        for (int i = 0; i < R; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bfs() {
        int time = 0;
        while (time++ < N) {
            if (time % 2 == 0) { // 짝수 시간일 때 모든 칸에 폭탄 설치
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (arr[i][j] == '.') {
                            arr[i][j] = 'O';
                            boom[i][j] = time + 3;
                        }
                    }
                }
            } else {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (boom[i][j] == time) { // 폭탄 터지는 시간인 경우
                            arr[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if (isInRange(nx, ny)) continue;

                                // 폭탄이 있는 자리이고, 터지는 시간이 아닌경우 -> 연쇄폭발
                                if (arr[nx][ny] == 'O' && boom[nx][ny] != time) {
                                    arr[nx][ny] = '.';
                                    boom[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isInRange(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= R || ny >= C;
    }

}

class Seat {
    int x;
    int y;

}

/**
 * 빈칸 . 폭탄 o
 * 1. 가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
 * 2. 다음 1초 동안 봄버맨은 아무것도 하지 않는다.
 * 3. 다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다.
 * 4. 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
 * 3,4 반복
 * 2초 3초 펑
 * 4포 5초 펑
 */