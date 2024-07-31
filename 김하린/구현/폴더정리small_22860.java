package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 골드 3 - 폴더 정리 (small)
 * - N : 폴더의 총 개수, M : 파일의 총 개수
 * - P : 상위 폴더의 이름, F : 폴더 또는 파일의 이름, C : 폴더면 1, 파일이면 0
 * - Q : 쿼리의 개수
 * 1. 폴더 및 파일 구조 생성 : Folder 객체, HashMap
 * 2. 쿼리 처리 : 쿼리에 대해 경로를 따라 폴더 탐색 후 해당 폴더 및 하위폴더에 있는 파일 종류, 총 개수 반환
 * 3. 결과 출력 : 계산된 파일 종류 개수, 총 개수 출력
 * 4. 오류 : 부모폴더랑 자식들 null 일 경우 예외처리 안해주면 런타임에러남.... 주의!!
 */
public class 폴더정리small_22860 {
    static StringTokenizer st;
    static int N, M;
    static HashMap<String, Folder> folderMap = new HashMap<>();

    // 폴더 객체
    static class Folder {
        String name; // 폴더 이름
        ArrayList<Folder> childFolders = new ArrayList<>(); // 하위 폴더 목록
        ArrayList<String> files = new ArrayList<>(); // 파일 목록
        Folder(String name) {
            this.name = name;
        }
    }

    static class Solution {
        public void solution(String[] input, String[] queries) {
            // 루트 폴더 생성
            Folder root = new Folder("main");
            folderMap.put("main", root);

            // 폴더 및 파일 구조 생성
            for (String line : input) {
                st = new StringTokenizer(line);
                String P = st.nextToken(); // 상위 폴더의 이름
                String F = st.nextToken(); // 폴더 또는 파일의 이름
                int C = Integer.parseInt(st.nextToken()); // 폴더면 1, 파일이면 0

                // parentFolder null 처리 추가
                Folder parentFolder = folderMap.get(P); // 상위 폴더 객체 가져오기
                if (parentFolder == null) {
                    parentFolder = new Folder(P);
                    folderMap.put(P, parentFolder);
                }

                // child null 처리 추가
                Folder child = folderMap.get(F);
                if (child == null) {
                    child = new Folder(F);
                }

                if (C == 1) { // F가 폴더일 경우
                    parentFolder.childFolders.add(child);// 상위 폴더의 하위 폴더 목록 추가
                    folderMap.put(F, child);
                } else { // F가 파일일 경우
                    parentFolder.files.add(F); // 상위 폴더의 파일 목록에 추가
                }
            }

            // 쿼리 처리
            for (String query : queries) {
                Folder currentFolder = findFolder(query); // 쿼리 경로를 따라 폴더 탐색
                HashSet<String> uniqueFiles = new HashSet<>(); // 파일 종류를 저장할 HashSet
                int totalFileCount = countFiles(currentFolder, uniqueFiles);
                System.out.println((uniqueFiles.size()) + " " + totalFileCount);
            }
        }

        // 경로를 따라 폴더 탐색
        private Folder findFolder(String path) {
            String[] pathElements = path.split("/");
            Folder currentFolder = folderMap.get("main");

            for (int i = 1; i < pathElements.length; i++) {
                for (Folder child : currentFolder.childFolders) { // 현재 폴더의 하위 폴더를 순회
                    if (child.name.equals(pathElements[i])) {
                        currentFolder = child; // 해당 폴더로 이동
                        break;
                    }
                }
            }
            return currentFolder;
        }

        // 폴더 및 하위 폴더의 파일을 계산
        private int countFiles(Folder folder, HashSet<String> uniqueFiles) {
            int fileCount = 0;
            // 현재 폴더의 파일
            for (String file : folder.files) {
                uniqueFiles.add(file);
                fileCount++;
            }

            // 현재 폴더의 하위 폴더들 재귀 탐색
            for (Folder child : folder.childFolders) {
                fileCount += countFiles(child, uniqueFiles);
            }
            return fileCount;
        }
    }

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 폴더의 총 개수
        M = Integer.parseInt(st.nextToken()); // 파일의 총 개수

        String[] input = new String[N + M];
        for (int i = 0; i < N + M; i++) {
            input[i] = br.readLine();
        }

        int Q = Integer.parseInt(br.readLine()); // 쿼리의 개수
        String[] queries = new String[Q];
        for (int i = 0; i < Q; i++) {
            queries[i] = br.readLine();
        }

        Solution s = new Solution();
        s.solution(input, queries);
    }
}
