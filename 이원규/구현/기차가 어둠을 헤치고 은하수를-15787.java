import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] train = new int[n + 1][21];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());
            if (order == 1) {
                int pos = Integer.parseInt(st.nextToken());
                train[trainNum][pos] = 1;
            } else if (order == 2) {
                int pos = Integer.parseInt(st.nextToken());
                train[trainNum][pos] = 0;
            } else if (order == 3) {
//                for (int j = 1; j < 20; j++) {
//                    train[trainNum][j + 1] = train[trainNum][j];
//                }
                for (int j = 20; j > 1; j--) {
                    train[trainNum][j] = train[trainNum][j - 1];
                }
                train[trainNum][1] = 0;
            } else if (order == 4) {
                for (int j = 1; j < 20; j++) {
                    train[trainNum][j] = train[trainNum][j + 1];
                }
                train[trainNum][20] = 0;
            }
        }
        // 중복체크
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                sb.append(train[i][j]);
            }
            set.add(sb.toString());
        }

        System.out.println(set.size());
    }
}


/**
 * 기차는 20개의 일렬로 된 좌석
 * N(1 ≤ N ≤ 100000)과 명령의 수 M(1 ≤ M ≤ 100000)
 * 1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람 탑승
 * 타있으면 아무것도 안함
 * 2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차
 * 3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로
 * 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차
 * 4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로
 * 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차
 * <p>
 * 중복체크 어떻게 할지 고민함.. set에 배열 넣어봤는데 실패
 * 아마 메모리 주소를 참조해서 그런듯함
 * String으로 변환해서 해결
 */