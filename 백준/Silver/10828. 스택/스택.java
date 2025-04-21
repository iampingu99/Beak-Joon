import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N; // 1 ≤ N ≤ 10,000

    static class CustomStack {
        final Deque<Integer> stack = new ArrayDeque<>();

        void push(int n) {
            stack.offer(n);
        }

        int pop() {
            if (stack.isEmpty()) return -1;
            return stack.pollLast();
        }

        int size() {
            return stack.size();
        }

        int isEmpty() {
            return stack.isEmpty() ? 1 : 0;
        }

        int top() {
            if (stack.isEmpty()) return -1;
            return stack.peekLast();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        CustomStack customStack = new CustomStack();

        while (N-- > 0) {
            String[] param = br.readLine().split(" ");
            switch (param[0]) {
                case "push": {
                    customStack.push(Integer.parseInt(param[1]));
                    break;
                }
                case "pop": {
                    answer.append(customStack.pop()).append("\n");
                    break;
                }
                case "size": {
                    answer.append(customStack.size()).append("\n");
                    break;
                }
                case "empty": {
                    answer.append(customStack.isEmpty()).append("\n");
                    break;
                }
                case "top": {
                    answer.append(customStack.top()).append("\n");
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
