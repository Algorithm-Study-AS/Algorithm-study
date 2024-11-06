import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[366];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) {
                arr[j]++;
            }
        }
        int result = 0;
        int len = 0;
        int max = 0;

        for (int i = 0; i <= 365; i++) {
            if (arr[i] == 0) { // 직사각형 만들고 더하기
                result += len * max;
                len = max = 0;
                continue;
            }
            len++;
            max = Math.max(max, arr[i]);
        }
        result += len * max;
        System.out.println(result);
    }
}

/**
 * 연속하는 일정들 다 포함하는 직사각형 만들기
 * 가장 일정 많은 날 * 총 연속된 일정
 */