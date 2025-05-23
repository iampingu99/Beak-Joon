import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_N = 10_000 + 1;
    static int N; // 1 ≤ n ≤ 10,000
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[MAX_N];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[MAX_N];
        dp[0] = 0;
        dp[1] = nums[1];
        dp[2] = nums[1] + nums[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 3] + nums[i] + nums[i - 1],
                            dp[i - 2] + nums[i]));
        }

        System.out.println(dp[N]);
    }
}
