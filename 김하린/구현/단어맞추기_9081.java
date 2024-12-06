package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 1 - 단어 맞추기
 * 1. 맨 뒤에서부터 확인후, 처음으로 감소하는 부분 찾기
 * 2. 감소하는 부분보다 큰 부분 찾고 스위치
 * 3. 뒷부분 오름차순
 */
public class 단어맞추기_9081 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++){
            char[] word = br.readLine().toCharArray();
            find(word);

        }

    }

    private static void find(char[] word){
        int len = word.length;

        int idx1 = -1; // 처음으로 감소하는 원소 위치
        int idx2 = 0; // idx1 원소보다 처음으로 큰 원소 위치

        // 1. 처음으로 감소하는 부분 찾기
        for (int i=len-1; i>0; i--){
            if(word[i-1] < word[i]){
                idx1 = i-1;
                break;
            }
        }

        // 마지막 순열일 경우
        if (idx1 == -1) {
            System.out.println(new String(word));
            return;
        }

        // 2. 감소하는 부분보다 큰 부분
        for (int i=len-1; i>0; i--){
            if(word[idx1] < word[i]){
                idx2 = i;
                break;
            }
        }

        // 3. idx1과 idx2 원소 swap
        char tmp = word[idx1];
        word[idx1] = word[idx2];
        word[idx2] = tmp;

        Arrays.sort(word, idx1+1, len);

        System.out.println(new String(word));
    }
}
