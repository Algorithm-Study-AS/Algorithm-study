import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        char[] arr = str.toCharArray();
        boolean[] check = new boolean[arr.length];
        char[] duck = {'q', 'u', 'a', 'c', 'k'};
        int idx = 0;
        int cnt = 0;

        if (arr[0] != 'q' || arr.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                // 방문한적 없는 배열이 quack의 순서를 잘 지켰으면 list에 넣어준다.
                if (!check[j] && arr[j] == duck[idx]) {
                    idx++;
                    list.add(arr[j]);
                    check[j] = true;
                    if (idx == 5) idx = 0;
                }
            }
            if (!list.isEmpty()) {
//                 반복문 마지막에 list에 값 제대로 들어갔는지 확인
                if (list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
//                // 위아래 다 가능한데 이게 시간이 좀 더 걸림
//                if (list.size() % 5 != 0) {
//                    System.out.println(-1);
//                    return;
//                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}


/**
 * q로 시작안하거나, 5의 배수가 아니면 -1 바로 출력
 * 반복문 돌면서 quack이 얼마나 만들어졌는지 체크한다.
 * <p>
 */