import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        A[N] = Integer.MAX_VALUE;

        Deque<Integer> stack = new ArrayDeque<>();
        long answer = 0;
        for (int i = 0; i <= N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                answer += i - stack.pop() - 1;
            }
            stack.push(i);
        }

        System.out.println(answer);
    }
}
