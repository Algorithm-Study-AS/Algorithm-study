import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            int left = -1; // 처음으로 감소하는 위치
            int right = 0; // 처음으로 큰 위치

            // 뒤 쪽에서부터 처음으로 숫자가 감소하는 지점체크
            for (int j = str.length() - 1; j > 0; j--) {
                if (ch[j - 1] < ch[j]) {
                    left = j - 1;
                    break;
                }
            }

            // 감소하는 지점이 없는 경우 -> 마지막 단어
            if (left == -1) {
                sb.append(str).append("\n");
                continue;
            }

            // 감소하는 지점보다 큰 지점 찾기
            for (int j = str.length() - 1; j > 0; j--) {
                if (ch[left] < ch[j]) {
                    right = j;
                    break;
                }
            }

            // left, right 자리 바꾸기
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;

            // left 뒷부분 오름차순 정렬
            Arrays.sort(ch, left + 1, str.length());
            for (char c : ch) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

/**
 * pq 만들어서 하면되려나?
 * 단어길이 최대 99 그냥 for문 다 돌리면 시간초과 날듯
 * 어차피 2등이니까 뒤에서부터 탐색해서 처음 바뀌는거 일듯함
 * H E L L O
 * 8 5 12 12 15
 * H E L O L
 * 8 5 12 15 12
 * <p>
 * S H U T T L E
 * 19 8 21 20 20 12 5
 * l = 8
 * r = 12
 * S L U T T H E
 * 19 12 21 20 20 8 5
 * 19 12 5 8 20 20 21
 * S L E H T T U
 */