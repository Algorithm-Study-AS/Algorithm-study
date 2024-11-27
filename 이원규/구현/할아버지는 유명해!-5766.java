import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            int[] cnt = new int[10001];
            int max = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int c = Integer.parseInt(st.nextToken());
                    cnt[c]++;
                    max = Math.max(c, max);
                }
            }
            Integer[] tmp = Arrays.stream(cnt).boxed().toArray(Integer[]::new);
            Arrays.sort(tmp, Collections.reverseOrder());
            int first = tmp[0];
            int second = 0;
            for (int i = 0; i <= max; i++) {
                if (tmp[i] != first) {
                    second = tmp[i];
                    break;
                }
            }
            for (int i = 1; i <= max; i++) {
                if (cnt[i] == second) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

/**
 * 각 선수는 1~10000까지의 정수(선수 번호)로 식별
 * N(2<=N<=500)주 동안의 매주 상위 M(2<=M<=500)명의 랭킹 정보
 * 입력에 해당하는 선수번호 값 증가 시키고, 2등 개수 구하기
 */