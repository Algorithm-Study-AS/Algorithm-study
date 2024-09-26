package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 실버 2 - DFS와 BFS
 */
public class DFS와BFS_1260 {
    static boolean[] visited;
    static int[][] graph;
    static int n;
    static int m;
    static int v;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        graph = new int[n+1][n+1];

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);
    }

    private static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
        for (int i=1; i<=n; i++){
            if (graph[v][i]==1 && !visited[i]) dfs(i);
        }
    }

    private static void bfs(int v){
        visited[v] = true;
        queue = new LinkedList<>();
        queue.add(v);
        System.out.print(v + " ");
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            for (int i=1; i<=n; i++){
                if (graph[tmp][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }

    }



}
