package 그리디;

import java.io.*;
import java.util.*;

/**
 * 실버 2 - 잃어버린 괄호
 * +, -, (, )
 * + 먼저 연산후 - 연산 하는 것이 최소
 */
public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sub = br.readLine().split("-"); // 55, 50+40

        int answer = Integer.MAX_VALUE; // 초기 상태
        for(int i=0; i<sub.length; i++){
            int tmp = 0;
            String[] add = sub[i].split("\\+"); // 55 / 50, 40
            for (int j=0; j<add.length; j++){
                tmp += Integer.parseInt(add[j]);
            }
            if (answer == Integer.MAX_VALUE) answer = tmp;
            else answer -= tmp;
        }

        System.out.println(answer);
    }
}
