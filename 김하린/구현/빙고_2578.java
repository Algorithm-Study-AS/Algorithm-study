package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 실버 4 - 빙고
 * 1. 가로, 세로, 왼오 대각선, 오왼 대각선 모두 체크하는 함수 구현
 * 2. count로 완성된 빙고 개수 체크후, 3 이상일 경우 인덱스값 반환
 * 처음에 BufferedReader, StringTokenizer 로 입력값을 받았었는데, Scanner 사용하는 것이 더 효율적인듯
 */
public class 빙고_2578 {
    static Scanner sc = new Scanner(System.in);
    static int count; // 빙고 개수
    static class Solution {
        public int solution(int[][] bingo) throws IOException {

            // 사회자 빙고 체크
            for (int i=1; i<=25; i++){
                int num = sc.nextInt();
                for (int a = 0; a < 5; a++) {
                    for (int b = 0; b < 5; b++) {
                        if (bingo[a][b] == num) { // 사회자 값과 일치시 0으로
                            bingo[a][b] = 0;
                        }
                    }
                }
                rCheck(bingo);
                cCheck(bingo);
                lrCheck(bingo);
                rlCheck(bingo);
                if (count >= 3) {
                    return i;
                }
                count=0;
            }
            return 0;
        }

        // 세로 체크
        private void cCheck(int[][] bingo) {
            for (int i=0; i<5; i++){
                int zeroCnt = 0;
                for (int j=0; j<5; j++){
                    if(bingo[j][i] == 0)
                        zeroCnt ++;
                }
                if(zeroCnt == 5)
                    count++;
            }
        }

        // 가로 체크
        private void rCheck(int[][] bingo) {
            for (int i = 0; i < 5; i++) {
                int zeroCnt = 0;
                for (int j = 0; j < 5; j++) {
                    if (bingo[i][j] == 0)
                        zeroCnt++;
                }
                if (zeroCnt == 5)
                    count++;
            }
        }

        // 오->왼 대각선 체크
        private void rlCheck(int[][] bingo) {
            int zeroCnt = 0;
            for(int i=0; i<5; i++){
                if(bingo[i][4-i] == 0){
                    zeroCnt++;
                }
            }
            if(zeroCnt == 5){
                count++;
            }
        }

        // 왼->오 대각선 체크
        private void lrCheck(int[][] bingo) {
            int zeroCnt = 0;
            for(int i=0; i<5; i++){
                if (bingo[i][i] == 0){
                    zeroCnt++;
                }
            }
            if (zeroCnt == 5){
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        int[][] bingo = new int[5][5];
        // 빙고 입력
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                bingo[i][j] = sc.nextInt();
            }
        }
        System.out.println(s.solution(bingo));
    }
}
