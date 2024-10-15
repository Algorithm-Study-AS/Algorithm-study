package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * <int><max>2147483647<long long><max>9223372036854775807
 */
public class 단어뒤집기2_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        Stack<String> stack = new Stack<>();
        String[] arr1 = str.split(" ");
        String[] arr2 = str.split(">");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        for (char ch : str.toCharArray()){
            if (ch == '<'){

            }
        }
    }
}
