package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 4
 * 설탕 배달
 * xkg를 만드는 최소 봉지 개수 = x가 5로 나누어 떨어질때 몫이 최소 봉지이다. 5로 나누어 떨어지지 않으면 -3을 해줘서 카운트를 1씩 증가시킨 후 몫을 더해주면 최소 봉지 개수다.
 * 1. 5로 나눈 나머지가 0이면 몫을 카운터에 더해주고 결과 반환한다.
 * 2. 그렇지 않으면 입력값에 -3을 해주고 카운터를 1 증가 시킨 후 5로 나누도록 반복해준다.
 * 3. 입력값이 음수일 경우 나누어 떨어지 않기 떄문에 -1을 반환한다.
 */
public class 설탕배달_2839 {
    static class Solution {
        public int solution(int x) {
            int count = 0;
            while (x >= 0){
                if (x % 5 == 0) {
                    count += x / 5;
                    return count;
                }
                x -= 3;
                count += 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(s.solution(Integer.parseInt(br.readLine())));
    }
}