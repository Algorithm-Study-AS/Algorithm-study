package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버 4 - 할아버지는 유명해!
 */
public class 할아버지는유명해_5766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean check = true;

        while (check){
            HashMap<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n==0 && m==0) check = false; // 탈출 조건

            for (int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<m; j++){
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num, map.getOrDefault(num,0)+1);
                }
            }

            int tmp = 0;
            int target = 0;

            // 2등 찾기 (더 좋은 방법 찾아보자..)
            for (int i : map.values()){
                tmp = Math.max(i, tmp);
            }
            for (int i : map.values()){
                if (i != tmp) {
                    target = Math.max(i, target);
                }
            }

            // 2등 해당하는 키 값 리스트에 넣어서 오름차순 출력
            List<Integer> list = new LinkedList<>();
            for (int i : map.keySet()){
                if (map.get(i) == target){
                    list.add(i);
                }
            }
            Collections.sort(list);
            for (int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
