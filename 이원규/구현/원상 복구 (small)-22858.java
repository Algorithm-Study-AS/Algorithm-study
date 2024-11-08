import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] D = new int[N + 1];
        int[] S = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmp = new int[N + 1];
        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                int t = D[j];
                tmp[t] = S[j];
            }
            S = tmp.clone();
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(tmp[i] + " ");
        }
    }
}

/**
 * 카드의 개수 N
 * 카드를 섞은 횟수인 K
 * K번 카드 섞은 후 배치 -> S 배열
 * D 배열 -> 셔플 순서 있는 배열
 * S 배열에 있는 수를 D 배열값의 위치로 이동 시키면 바로 전 배열
 */