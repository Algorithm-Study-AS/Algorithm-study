package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * 실버 3 - 파일 정리
 * . 기준으로 split 할 때 앞에 // 붙여줘야함
 * 사전순으로 정렬하기 위해 TreeMap 사용, TreeMap은 자동정렬 해준다는 것 알게됨
 */
public class 파일정리_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> fileExtensions = new HashMap<>();

        // 파일 확장자 별 개수를 HashMap에 저장
        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();
            String[] extension = fileName.split("\\.");
            fileExtensions.put(extension[1], fileExtensions.getOrDefault(extension[1], 0) + 1);
        }

        // HashMap을 TreeMap으로 변환하여 사전 순으로 정렬
        TreeMap<String, Integer> sortedExtensions = new TreeMap<>(fileExtensions);

        // 결과 출력
        for (Map.Entry<String, Integer> entry : sortedExtensions.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
