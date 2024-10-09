package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 실버 2 - 오리
 */
public class 오리_12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] duck = {'q','u','a','c','k'};
        int[] count = new int[5]; // quack 등장 횟수
        int answer = 0; // 전체 중 울고 있는 오리 최대 수
        int current = 0; // 현재 quack 오리 수

        for (char ch : str.toCharArray()){
            int idx = -1;
            for (int i=0; i<5; i++){
                if (duck[i] == ch) { // 현재 문자 위치
                    idx = i;
                    break;
                }
            }
            if (idx==0) { // q일때
                current++;
                answer = Math.max(answer, current); // 최대 오리수 갱신
            } else if (count[idx - 1] <= count[idx]) {
                System.out.println(-1);
                return;
            }
            count[idx]++;
            if (idx == 4) { // k일 때 -> 울음소리가 끝난 것이므로 active 감소
                current--;
            }
        }

        // 모든 오리가 완전히 울었는지 확인
        if (current != 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
