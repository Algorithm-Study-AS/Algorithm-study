import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int n, k;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
        } else {
            getResult();
            System.out.println(min);
        }
    }

    private static void getResult() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curPosition = cur.position;
            int curTime = cur.time;

            if (curPosition == k) {
                min = cur.time;
            }
            if (curPosition * 2 <= 100000 && !visited[curPosition * 2]) {
                q.add(new Node(curPosition * 2, curTime));
                visited[curPosition * 2] = true;
            }
            if (curPosition - 1 >= 0 && !visited[curPosition - 1]) {
                q.add(new Node(curPosition - 1, curTime + 1));
                visited[curPosition - 1] = true;
            }
            if (curPosition + 1 <= 100000 && !visited[curPosition + 1]) {
                q.add(new Node(curPosition + 1, curTime + 1));
                visited[curPosition + 1] = true;
            }
        }
    }
}

class Node {
    int position;
    int time;

    public Node(int position, int time) {
        this.position = position;
        this.time = time;
    }
}

/**
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 걷는다면 1초 후에 X-1 또는 X+1로 이동
 * 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동
 * 5 17 일때
 * 5-10-9-18-17 순으로 가면 2초
 */