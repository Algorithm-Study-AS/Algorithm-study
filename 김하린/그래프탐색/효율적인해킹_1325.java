package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 1 - 효율적인 해킹
 * A가 B 신뢰 == B 해킹하면 A도 해킹 가능
 * 5, 4 -> 3 / 3 -> 1, 2 : 1,2 해킹하면 3, 5, 4 해킹 가능
 * DFS로 풀음
 */
public class 효율적인해킹_1325 {
    static int N, M;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] count;
    public static void dfs(int i){
        visit[i] = true;
        // i번 컴퓨터가 신뢰하는 다른 컴퓨터들을 탐색
        for(int next: arr.get(i)) {
            if (visit[next]) continue;
            count[next]++; // 해킹 가능 컴퓨터 수 계산
            dfs(next);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 컴퓨터의 수
        M = Integer.parseInt(st.nextToken()); // 신뢰 관계의 수

        arr = new ArrayList<>(); // 각 컴퓨터가 신뢰하는 다른 컴퓨터들을 저장하는 리스트
        count = new int[N + 1]; // 컴퓨터가 해킹할 수 있는 컴퓨터의 수
        int max = -1;
        String answer = "";

        for (int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b); // a컴퓨터 b 신뢰
        }

        // 해킹 가능 컴퓨터 수 세기
        for (int i=1; i<=N; i++){
            visit = new boolean[N+1]; // 방문여부 매번 초기화
            dfs(i);
        }

        // 최댓값 찾기
        for (int i = 1; i <= N; i++) {
            if (max < count[i])
                max = count[i];
        }

        // 최댓값인 사람들 출력
        for (int i=1; i<=N; i++){
            if (max == count[i]) answer += (i + " ");
        }
        System.out.println(answer);
    }
}
