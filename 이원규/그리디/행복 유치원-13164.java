import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(arr[i] - arr[i - 1]);
        }
        Collections.sort(list);

        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += list.get(i);
        }

        System.out.println(result);
    }
}

/**
 * n명의 유치원생 키 순서대로 정렬, k개의조로 나누기
 * 각 조에는 원생이 적어도 한 명 있어야 하며, 같은 조에 속한 원생들은 서로 인접
 * 1 3 5 6 10
 * 인접한 유치원생의 차이들 중에 상위 3개만?
 * 2 3 1 4 -> 1 2 3 4
 * 키 차이의 개수 n-1개
 * 그룹을 나는 구분선 개수 k-1개
 * (n - 1) - (k - 1) = n - k
 */