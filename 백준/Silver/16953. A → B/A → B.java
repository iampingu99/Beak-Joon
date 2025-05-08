import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static class Node {
        long value;
        int dist;

        public Node(long value, int dist) {
            this.value = value;
            this.dist = dist;
        }
    }
    
    static long A, B; // 1 ≤ A < B ≤ 10^9

    static long bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.value == B) return curr.dist;
            long op1 = curr.value * 2;
            long op2 = curr.value * 10 + 1;
            if (op1 <= B) queue.offer(new Node(op1, curr.dist + 1));
            if (op2 <= B) queue.offer(new Node(op2, curr.dist + 1));
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
