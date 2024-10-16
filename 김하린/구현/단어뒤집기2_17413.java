package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어 뒤집기 2 - 실버 3
 */
public class 단어뒤집기2_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String input = br.readLine();
        StringBuilder tmp = new StringBuilder(); // 임시 변수
        boolean insideTag = false; // 태그 여부 확인

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 태그 처리
            if (c == '<') {
                result.append(tmp.reverse()); // 이전 단어 처리
                tmp.setLength(0);
                insideTag = true;
                result.append(c);
            } else if (c == '>') {
                insideTag = false;
                result.append(c);
            } else if (insideTag) result.append(c);
            // !태그 처리
            else {
                if (c == ' ') {
                    result.append(tmp.reverse());
                    tmp.setLength(0);
                    result.append(' ');
                } else tmp.append(c);
            }
        }
        result.append(tmp.reverse());
        System.out.println(result);
    }
}
