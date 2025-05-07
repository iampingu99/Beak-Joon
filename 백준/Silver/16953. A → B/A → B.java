import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    static final int MAX_SIZE = 1_000_000_000;
    static long A, B; // 1 ≤ A < B ≤ 10^9

    static long bfs() {
        Queue<long[]> queue = new ArrayDeque<>();
        Map<Long, Long> result = new HashMap<>();
        queue.offer(new long[]{A, 1});
        result.put(A, 1L);

        while (!queue.isEmpty()) {
            long[] curr = queue.poll();
            if (curr[0] == B) return curr[1];
            long op1 = curr[0] * 2;
            long op2 = Long.parseLong(curr[0] + "1");
            if (!result.containsKey(op1) && op1 <= B) {
                queue.offer(new long[]{op1, curr[1] + 1});
                result.put(op1, curr[1] + 1);
            }
            if (!result.containsKey(op2) && op2 <= B) {
                queue.offer(new long[]{op2, curr[1] + 1});
                result.put(op2, curr[1] + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        A = Long.parseLong(param[0]);
        B = Long.parseLong(param[1]);

        System.out.println(bfs());
    }
}
