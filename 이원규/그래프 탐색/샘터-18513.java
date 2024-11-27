import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            q.add(new int[]{cur, 0});
            visited.add(cur);
        }

        int[] dx = {-1, 1};
        long ans = 0;
        while (!q.isEmpty() && K > 0) {
            int[] cur = q.poll();
            int position = cur[0]; // 현재 위치
            int dist = cur[1]; // 현재 거리

            for (int d : dx) {
                int next = position + d; // 다음 위치 계산
                if (visited.contains(next)) continue; // 이미 방문한 위치는 건너뜀

                ans += dist + 1; // 불행도 계산
                visited.add(next); // 방문 처리
                q.add(new int[]{next, dist + 1}); // 다음 위치와 거리 추가
                K--; // 집을 하나 지음

                if (K == 0) break; // 모든 집을 지었다면 종료
            }
        }

        System.out.println(ans);
    }
}

/**
 * 왜 bfs지..?
 * 생각이 안나서 참고함..
 */