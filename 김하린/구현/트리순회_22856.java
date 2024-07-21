package 구현;

import java.util.Scanner;

/**
 * 골드 4 - 트리순회
 * 1. node 배열에 (현재 노드, 왼쪽 자식, 오른쪽 자식) 을 입력받음
 * 2. 중위 순회 함수 호출 : 재귀적으로 왼쪽 자식 방문후 현재 노드 방문후 오른쪽 자식 방문. lastInOrder 변수로 마지막 방문 노드 기록
 * 3. 유사 중위 순회 함수 호출 : 현재 노드 방문 후 왼쪽 자식노드 방문후 count 증가, 오른쪽 자식 노드 방문 후 count 증가.
 *                           현재 노드가 lastInOrder 과 같으면 함수 실행 종료.
 * 4. 방문 횟수인 count 출력
 */
public class 트리순회_22856 {
    static Scanner sc = new Scanner(System.in);
    static int count = 0;
    static int lastInOrder = 1;
    static boolean flag = false;
    static boolean[] visit;
    static int[][] node;

    public static void main(String[] args){
        int N = (sc.nextInt())+1;
        node = new int[N][2];
        visit = new boolean[N];
        visit[0] = true;

        // 노드 입력받기
        for (int i = 1; i < N; i++) {
            int current = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            node[current][0] = a;
            node[current][1] = b;
        }

        inorder(1);
        similarInOrder(1);
        System.out.println(count);
    }

    // 유사 중위 순회 함수
    private static void similarInOrder(int current) {
        visit[current] = true;
        if (node[current][0] != -1 && !visit[node[current][0]]){
            count ++;
            similarInOrder(node[current][0]);
        }
        if (node[current][1] != -1 && !visit[node[current][1]]){
            count++;
            similarInOrder(node[current][1]);
        }

        if(lastInOrder == current) flag = true;
        if(flag) return;
        count ++;
    }

    // 중위 순회
    private static void inorder(int current) {
        if(node[current][0] != -1){
            inorder(node[current][0]);
        }
        lastInOrder = current;
        if(node[current][1] != -1){
            inorder(node[current][1]);
        }
    }
}
