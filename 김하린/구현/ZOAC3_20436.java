package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 4 - ZOAC 3
 */
public class ZOAC3_20436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String left = st.nextToken();
        String right = st.nextToken();
        String input = br.readLine();

        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        String mo = "yuiophjklbnm"; // 모음

        int xl=0, yl=0, xr=0, yr=0;
        int time = 0;

        // 초기 왼손 위치
        for (int i = 0; i < keyboard.length; i++) {
            if (keyboard[i].contains(left)) {
                xl = i;
                yl = keyboard[i].indexOf(left);
            }
            if (keyboard[i].contains(right)) {
                xr = i;
                yr = keyboard[i].indexOf(right);
            }
        }
        // 문자열 입력에 걸리는 시간 계산
        for (char c : input.toCharArray()) {
            time++; // 키를 누르는 데 1초
            if (mo.indexOf(c) != -1) { // 모음인지 확인
                for (int i = 0; i < keyboard.length; i++) {
                    if (keyboard[i].indexOf(c) != -1) {
                        int nx = i;
                        int ny = keyboard[i].indexOf(c);
                        time += Math.abs(nx - xr) + Math.abs(ny - yr);
                        xr = nx;
                        yr = ny;
                        break;
                    }
                }
            } else { // 자음일 경우
                for (int i = 0; i < keyboard.length; i++) {
                    if (keyboard[i].indexOf(c) != -1) {
                        int nx = i;
                        int ny = keyboard[i].indexOf(c);
                        time += Math.abs(nx - xl) + Math.abs(ny - yl);
                        xl = nx;
                        yl = ny;
                        break;
                    }
                }
            }
        }
        System.out.println(time);
    }
}
