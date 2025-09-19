import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while (deque.size() != 1) {
            sb.append(deque.poll()).append(" ");
            deque.offer(deque.poll());
        }
        sb.append(deque.poll());
        System.out.println(sb);
    }
}
