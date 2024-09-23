import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int res = 0;

        ArrayList<Integer> crane = new ArrayList<>();
        ArrayList<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        while (!box.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < n; ) {
                if (idx == box.size()) break;
                else if (crane.get(i) >= box.get(idx)) { //크레인이 박스를 옮기면 다음 크레인사용
                    box.remove(idx);
                    i++;
                } else idx++;
            }
            res++;
        }
        System.out.println(res);
    }

}

/**
 * 크레인 개수 N <= 50
 * 둘째 줄에는 각 크레인의 무게 제한 <= 1000000
 * 박스의 수 M < 10000
 * 각 박스의 무게 <= 1000000
 * 내림차순으로 크레인과 무게 정렬
 * 크레인이 박스를 옮기면 다음 크레인사용
 * 1분에 모든 크레인이 동시에 움직이기 때문에 while문 한번에 res++ 한번
 */