package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 3 - 바이러스
 * DFS로 품
 */
public class 바이러스_2606 {
    static int[][] network;
    static boolean[] visit;
    static int n, com;
    static int count = 0;
    public static int dfs(int i){
        visit[i] = true;
        for(int j=1; j<=com; j++) {
            if(network[i][j] == 1 && !visit[j]) {
                count ++;
                dfs(j);
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        com = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        n = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수
        network = new int[com+1][com+1]; // 네트워크 배열
        visit = new boolean[com+1];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a][b] = network[b][a] = 1;
        }
        System.out.println(dfs(1));
    }
}
