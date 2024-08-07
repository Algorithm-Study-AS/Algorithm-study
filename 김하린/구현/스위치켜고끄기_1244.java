package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 실버 4 - 스위치 켜고 끄기
 */
public class 스위치켜고끄기_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치
        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] status = new int[n]; // 스위치 상태
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }

        // 학생
        int studentCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            // 남학생
            if (gender == 1) {
                for (int j = num - 1; j < n; j += num) {
                    status[j] = status[j] == 0 ? 1 : 0;
                }
            }
            // 여학생
            else if (gender == 2) {
                int left = num - 2;
                int right = num;
                // num에 해당하는 스위치의 상태를 토글
                status[num - 1] = status[num - 1] == 0 ? 1 : 0;
                // 좌우 대칭인 스위치의 상태를 토글
                while (left >= 0 && right < n && status[left] == status[right]) {
                    status[left] = status[left] == 0 ? 1 : 0;
                    status[right] = status[right] == 0 ? 1 : 0;
                    left--;
                    right++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(status[i] + " ");
            if ((i + 1) % 20 == 0) { // 결과 20개씩 끊어서 출력
                System.out.println();
            }
        }
    }
}
