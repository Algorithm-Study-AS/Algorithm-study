package 그래프탐색;

import java.util.*;
import java.util.Scanner;

/**
 * 골드 5 - 숨바꼭질
 * N : 수빈 현재 점
 * K : 동생
 * 걷기 : 수빈 위치 X -> 1초 후 -> X-1 or X+1 로 이동
 * 순간이동 : -> 0초 후 -> 2*X 로 이동
 * 5 - 10 - 9 - 18 - 17
 * 모든 경우 다 탐색해야함
 */
public class 숨바꼭질3_13549 {
    static int n; // 수빈 현재
    static int k; // 동생
    static boolean[] visited;
    static int max = 100000;
    static Queue<Node> queue = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[max+1];
        bfs();
        System.out.println(answer);
    }

    private static void bfs(){
        queue.offer(new Node(n, 0)); // 현재 위치와 시간 노드에 저장
        while(!queue.isEmpty()){
            Node node = queue.poll(); // 노드 꺼내기
            int x = node.x;
            int time = node.time;
            visited[x] = true;

            // 동생 위치에 도달
            if (x == k) answer = Math.min(answer, time);

            // 순간이동 - 0초
            if (x*2 <= max && visited[x*2]==false) queue.offer(new Node(x*2, time));
            // 걷기 - 1초
            if (x+1 <= max && visited[x+1]==false) queue.add(new Node(x+1, time+1));
            if (x-1 >=0 && visited[x-1]==false) queue.add(new Node(x-1, time+1));
        }
    }
    private static class Node{
        int x; // 현재 위치
        int time; // 걸린 시간
        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
}
