package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.*;

/**
 * 골드 5 - 배
 * 크레인 한바퀴 돌면서 박스 넣기
 * 1. 처음에 크레인에 누적되어 박스가 쌓이는 줄 알아서 실패
 * 2. crane, box 둘 다 배열로 풀다가, box 처리가 어려워서 box만 ArrayList로 바꿈
 */
public class 배_1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 크레인
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] crane = new Integer[n];
        for (int i=0; i<n; i++){
            crane[i] = Integer.parseInt(st.nextToken());
        }
        // 박스
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        for (int i=0; i<m; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(crane, Collections.reverseOrder());
        box.sort(Collections.reverseOrder());


        int answer = 0;
        if (box.get(0) > crane[0]) {
            System.out.println(-1);
            return;
        }
        while (!box.isEmpty()){
            int boxidx = 0, craneidx = 0;
            while (craneidx < n){
                if (boxidx == box.size()) break;
                if (box.get(boxidx) <= crane[craneidx]) {
                    box.remove(boxidx);
                    craneidx++;
                }
                else boxidx++;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
