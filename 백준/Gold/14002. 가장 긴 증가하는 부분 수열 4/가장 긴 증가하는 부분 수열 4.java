import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000
    static int[] nums, dp; // 1 ≤ Ai ≤ 1,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(answer, dp[i]);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N - 1, j = answer; i >= 0 && j >= 0; i--) {
            if (dp[i] == j) {
                deque.offerFirst(nums[i]);
                j--;
            }
        }

        deque.forEach(v -> sb.append(v).append(" "));

        System.out.println(answer);
        System.out.println(sb);
    }
}
