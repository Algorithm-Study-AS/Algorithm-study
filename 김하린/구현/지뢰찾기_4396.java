package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 4 - 지뢰 찾기
 * 1. 지뢰, 여는 칸 입력받기
 * 2. 칸 열었을 때 (x) -> 지뢰면 *, 지뢰 아니면 8칸 조사하여 카운트 증가
 * 3. 지뢰 열었을 때 카운트 증가시킨 상태로 지뢰부분 *로 출력해야함.. 지뢰만 출력하면 틀렸습니다 나옴
 */
public class 지뢰찾기_4396 {
    static char[][] map;
    static char[][] find;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean bomb = false;
    static class Solution {
        public void solution(int n, char[][] map, char[][] find) {
            for (int i = 0; i<n; i++){
                for (int j=0; j<n; j++){
                    // 칸 열었을 때
                    if (find[i][j] == 'x'){
                        // 지뢰일 경우
                        if (map[i][j] == '*'){
                            bomb = true;
                        }
                        // 지뢰가 아닐 경우
                        else {
                            int count = 0;
                            // 8칸 검사
                            for (int k=0; k<8; k++){
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                // 8칸 중에 지뢰 있으면 count 증가
                                if (nx >=0 && nx < n && ny >=0 && ny <n && map[nx][ny]=='*') count++;
                            }
                            find[i][j] = (char) (count + '0'); // int to char
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        find = new char[n][n];

        // 지뢰 입력받기
        for (int i = 0; i<n; i++){
            String s = br.readLine();
            for (int j=0; j<n; j++){
                map[i][j] = s.charAt(j);
            }
        }

        // 여는 칸 입력받기
        for (int i = 0; i<n; i++){
            String s = br.readLine();
            for (int j=0; j<n; j++){
                find[i][j] = s.charAt(j);
            }
        }

        Solution s = new Solution();
        s.solution(n, map, find);

        // 지뢰 열었을 경우 지뢰부분 *으로
        if (bomb){
            for (int i=0; i<n; i++){
                    for (int j=0; j<n; j++){
                        if (map[i][j] == '*'){
                            find[i][j] = '*';
                        }
                }
            }
        }

        // 결과 출력
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(find[i][j]);
            }
            System.out.println();
        }
    }
}

