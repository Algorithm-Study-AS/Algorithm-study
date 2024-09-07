import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        int sum = Integer.MAX_VALUE;

        String[] tokens = str.split("-");
        for (String token : tokens) {
            String[] add = token.split("\\+");
            int tmp = 0;
            for (String s : add) {
                tmp += Integer.parseInt(s);
            }
            if (sum == Integer.MAX_VALUE) // 제일 처음 요소일 겨우 sum에 담는다.
                sum = tmp;
            else
                sum -= tmp;
        }
        System.out.println(sum);
    }
}

/**
 * +는 상관없을 것 같은데 -나오면 경우가 나뉠듯함.
 * 먼저 -로 구분지어서 배열 만들고 반복문
 * 최소가 되려면 처음 요소에서 계속 -해야함
 * 앞쪽부터 순서대로 +있으면 더해서 tmp에 넣고. 최초 sum에서 빼준다.
 */