import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        cnt = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
        }

        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, cnt[i]);
        }

        for (int i = 1; i < n + 1; i++) {
            if (max == cnt[i]) System.out.print(i + " ");
        }

    }

    private static void bfs(int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : nodes.get(cur)) {
                if (!visited[next]) {
                    cnt[next]++;
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

}

/**
 * N은 10,000보다 작거나 같은 자연수,
 * M은 100,000보다 작거나 같은 자연수
 * a가 b 신뢰 -> b 해킹시 a 해킹 -> 방향o
 */