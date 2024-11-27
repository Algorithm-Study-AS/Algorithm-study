import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        K = K + 1;

        int tmp = 0;
        while (K != 0) {
            tmp = K % 2;
            sb.append(tmp);
            K /= 2;
        }
        int len = sb.length();
        StringBuilder ans = new StringBuilder();

        // 거꾸로 진수가 저장되었으므로 for문 반대로함
        for (int i = len - 2; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                ans.append(4);
            } else {
                ans.append(7);
            }
        }
        System.out.println(ans);
    }
}

/**
 * 4와 7로 이루어진 수
 * K번째로 작은 수
 * 1 ≤ K ≤ 10^9
 * 4,7 조합으로 쭉 돌려서 pq에 넣기?
 * 근데 쭉 돌리면 2^30 만큼 아닌가? 시간초과 날듯
 * k를 이진수로 만들어서 4랑7로 치환하자.
 * K가 1부터 시작하니까 +1 하고 계산
 */