import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> bfsResult = new LinkedList<>();
    static Queue<Integer> dfsResult = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점
        M = Integer.parseInt(st.nextToken()); //간선
        V = Integer.parseInt(st.nextToken()); //탐색시작정점

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        visited = new boolean[N + 1];
        dfs(V);
        visited = new boolean[N + 1];
        bfs();
        while (!dfsResult.isEmpty()) {
            System.out.print(dfsResult.poll() + " ");
        }
        System.out.println();
        while (!bfsResult.isEmpty()) {
            System.out.print(bfsResult.poll() + " ");
        }
    }

    private static void dfs(int num) {
        visited[num] = true;
        dfsResult.add(num);
        for (int node : graph.get(num)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        bfsResult.add(V);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int node : graph.get(v)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                    bfsResult.add(node);
                }
            }
        }
    }
}


/**
 * 그래프 만들고 정렬 시킨뒤 dfs, bfs 탐색
 */