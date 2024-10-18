import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String str = br.readLine();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            queue.offer(c);
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb = new StringBuilder();
            if (c == '<') {
                sb.append(c);
                while (queue.peek() != '>') {
                    sb.append(queue.poll());
                }
                sb.append(queue.poll());
                result.append(sb.toString());
            } else if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
                while (!queue.isEmpty()) {
                    if (queue.peek() == ' ') {
                        result.append(sb.reverse().toString()).append(queue.poll());
                        break;
                    }
                    if (queue.peek() == '<') {
                        result.append(sb.reverse().toString());
                        break;
                    }
                    sb.append(queue.poll());
                }
                if (queue.isEmpty()) {
                    result.append(sb.reverse().toString());
                }
            }
        }
        System.out.println(result);
    }
}


/**
 *
 */