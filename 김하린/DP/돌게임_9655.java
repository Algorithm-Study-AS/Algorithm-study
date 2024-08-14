package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 5 - 돌 게임
 * 돌 N -= 상근1 or 창영3
 * - N 홀수 : 상근 승
 * - N 짝수 : 창영 승
 */
public class 돌게임_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((N % 2 == 0)? "CY" : "SK");
    }
}
