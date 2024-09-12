package 그래프탐색;

import java.io.*;
import java.util.*;

/**
 * 실버2 - 트리의 부모 찾기
 * 1 -> 6, 4
 * 2 -> 4
 * 3 -> 5, 6
 * 4 -> 1, 2, 7
 * 5 -> 3
 * 6 -> 1, 3
 * 7 -> 4
 */
public class 트리의부모찾기_11725 {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visit;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        tree = new ArrayList[N+1];
        parent = new int[N+1];

        for (int i=0; i<N+1; i++){
            tree[i] = new ArrayList<>();
        }

        // 연결 노드 값
        for (int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(1);

        for (int i=2; i<parent.length; i++){
            System.out.println(parent[i]);
        }
    }
    private static void dfs(int idx){
        visit[idx] = true;
        for (int i: tree[idx]){
            if (!visit[i]){
                parent[i] = idx; // 각 노드의 부모값 저장
                dfs(i);
            }
        }
    }
}
