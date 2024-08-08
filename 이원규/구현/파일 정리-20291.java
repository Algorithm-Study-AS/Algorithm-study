import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 폴더의 총 개수
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String file = str.split("\\.")[1];
            if (map.get(file) == null) {
                map.put(file, 1);
            } else {
                map.put(file, map.get(file) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
/**
 * 1 <= n <= 50000
 */