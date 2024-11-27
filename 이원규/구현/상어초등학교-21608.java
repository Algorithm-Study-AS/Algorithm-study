import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, int[]> map;
    static int[][] arr;
    static int n, result = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        map = new HashMap<>();

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int l3 = Integer.parseInt(st.nextToken());
            int l4 = Integer.parseInt(st.nextToken());

            // Map에 친구 정보 저장
            map.put(cur, new int[]{l1, l2, l3, l4});

            // 현재 학생 cur 자리 정하기
            setSeat(cur);
        }
        // 만족도 계산
        getScore();
        System.out.println(result);
    }

    private static void getScore() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                int[] friend = map.get(arr[i][j]);
                // 좌표 주변 돌면서 좋아하는 친구 수 cnt++
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (isInRange(nx, ny)) continue;

                    for (int l = 0; l < 4; l++) {
                        if (arr[ny][nx] == friend[l]) cnt++;
                    }
                }
                // cnt 따라서 점수 계산
                switch (cnt) {
                    case 1:
                        result += 1;
                        break;
                    case 2:
                        result += 10;
                        break;
                    case 3:
                        result += 100;
                        break;
                    case 4:
                        result += 1000;
                        break;
                }
            }
        }
    }

    private static void setSeat(int cur) {
        int[] friend = map.get(cur); // 좋아하는 친구
        ArrayList<Seat> seats = new ArrayList<>(); // 앉을 자리 정보

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int emptyCnt = 0;
                int friendCnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (isInRange(nx, ny)) continue;

                    // 좋아하는 친구가 있으면 cnt증가
                    for (int l = 0; l < 4; l++) {
                        if (arr[ny][nx] == friend[l]) friendCnt++;
                    }
                    // 빈공간 cnt 증가
                    if (arr[ny][nx] == 0) emptyCnt++;
                }
                seats.add(new Seat(j, i, emptyCnt, friendCnt));
            }
        }
        // 1,2,3 조건 적용
        seats.sort((s1, s2) -> {
            if (s1.friendCnt == s2.friendCnt) { // 좋아하는 학생수 같을 경우
                if (s1.emptyCnt == s2.emptyCnt) { // 비어있는 학생수 같을 경우
                    if (s1.y == s2.y) { // 행 번호 같을 경우
                        return s1.x - s2.x; // 열 번호 정렬
                    }
                    return s1.y - s2.y; // 행 번호 정렬
                }
                return s2.emptyCnt - s1.emptyCnt; // 비어있는 칸 많은 순서
            }
            return s2.friendCnt - s1.friendCnt; // 좋아하는 학생 많은 순서
        });

        // 자리 업데이트
        for (Seat seat : seats) {
            if (arr[seat.y][seat.x] != 0) continue;
            arr[seat.y][seat.x] = cur;
            return;
        }
    }

    private static boolean isInRange(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= n;
    }
}

class Seat {
    int x;
    int y;
    int emptyCnt;
    int friendCnt;

    public Seat(int x, int y, int emptyCnt, int friendCnt) {
        this.x = x;
        this.y = y;
        this.emptyCnt = emptyCnt;
        this.friendCnt = friendCnt;
    }
}

/**
 * |r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸이 (r1, c1)과 (r2, c2)를 인접하다고 한다.
 * 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
 * 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.\
 * 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로,
 * 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
 */