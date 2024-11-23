package 구현;

import java.util.*;
import java.io.*;

/**
 * 골드 5 - 4와 7
 * 4
 * 7
 * 44
 * 47
 * 74
 * 77
 * 444
 * 447
 * 474
 * 744
 * 747
 * 774
 * 777
 */
public class 사와7 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()) +1;
        StringBuilder sb = new StringBuilder();
        String res = "";
        int num = 0;
        while (k!=0){
            num = k%2;
            sb.append(num);
            k = k/2;
        }
        for (int i=sb.toString().length()-2; i>=0; i--){
            if (sb.charAt(i) == '0') res += 4;
            else res += 7;
        }
        System.out.println(res);
    }
}
