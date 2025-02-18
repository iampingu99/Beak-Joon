import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MOD = 10_007;
    static int N; // 1 ≤ N ≤ 1,000
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 2][10];
        Arrays.fill(dp[1], 1);
        dp[2][0] = 10;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] - dp[i - 1][j - 1] + MOD) % MOD;
            }
            dp[i + 1][0] = Arrays.stream(dp[i]).sum() % MOD;
        }

        System.out.println(dp[N + 1][0]);
    }
}
