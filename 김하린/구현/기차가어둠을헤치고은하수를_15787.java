package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버 2 - 기차가 어둠을 헤치고 은하수를
 * trains 배열에 각 기차 상태를 넣음
 * 1 - i 기차 x 좌석 승차
 * 2 - i 기차 x 좌석 하차
 * 3 - i 기차 한칸 뒤로
 * 4 - i 기차 한칸 앞으로
 */
public class 기차가어둠을헤치고은하수를_15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 기차 수
        int m = Integer.parseInt(st.nextToken()); // 명령 수
        int[][] trains = new int[n][20];

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken())-1;
            int seat = 0;
            switch(command){
                case 1:
                    seat = Integer.parseInt(st.nextToken());
                    trains[train][seat-1] = 1;
                    break;
                case 2:
                    seat = Integer.parseInt(st.nextToken());
                    trains[train][seat-1] = 0;
                    break;
                case 3:
                    for (int j=19; j>0; j--) {  // 뒤에서부터 이동
                        trains[train][j] = trains[train][j-1];
                    }
                    trains[train][0] = 0;
                    break;
                case 4:
                    for (int j=0; j<19; j++){
                        trains[train][j] = trains[train][j+1];
                    }
                    trains[train][19] = 0;
                    break;
            }
        }

        Set<String> set = new HashSet<>();

        // 같은 배열 비교하는 방법 모르겠어서 String으로 변환하고 set에 넣어서 중복 제거함
        for (int i=0; i<trains.length; i++){
            String str = "";
            for (int j=0; j<20; j++){
                str += trains[i][j];
            }
            set.add(str);
        }

        System.out.println(set.size());
    }
}
