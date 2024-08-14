package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 골드 5 - 홀수 홀릭 호석
 * cut 함수 호출 할 때마다 각 자릿수의 홀수 개수 sum에 넣음
 * 세 자리 수 이상일 때 모든 가능한 경우의 수로 3개로 나눔
 * 재귀호출해서 min, max 값 업데이트
 */
public class 홀수홀릭호석_20164 {
    static int min = 9999, max=0;
    public static void cut(String n, int sum){
        // 홀수 개수의 합
        for (int i=0; i<n.length(); i++){
            int tmp = n.charAt(i) - '0';
            if (tmp % 2 != 0) sum++;
        }
        // 한 자리
        if (n.length()==1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        // 두 자리
        else if (n.length()==2){
            n = String.valueOf((n.charAt(0) - '0') + (n.charAt(1) - '0'));
            cut(n, sum);
        }
        // 세 자리 이상
        else{
            for (int i=1; i<n.length()-1; i++){
                for (int j=i+1; j<n.length(); j++){
                    int a = Integer.parseInt(n.substring(0,i));
                    int b = Integer.parseInt(n.substring(i, j));
                    int c = Integer.parseInt(n.substring(j));
                    cut(String.valueOf(a + b + c), sum);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cut(br.readLine(), 0);
        System.out.println(min + " " + max);
    }
}
